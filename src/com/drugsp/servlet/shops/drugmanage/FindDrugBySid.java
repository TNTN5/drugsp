package com.drugsp.servlet.shops.drugmanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Classify;
import com.drugsp.bean.Drugs;
import com.drugsp.bean.Shops;
import com.drugsp.service.ClassifyService;
import com.drugsp.service.DrugsService;
import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ClassifyServiceImpl;
import com.drugsp.service.impl.DrugsServiceImpl;
import com.drugsp.service.impl.ShopsServiceImpl;
@WebServlet("/finddrugbysid.do")
/*
 * 查询用户发布的所有商品
 * */
public class FindDrugBySid extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DrugsService ds=new DrugsServiceImpl();
		ShopsService ss=new ShopsServiceImpl();
		ClassifyService cs=new ClassifyServiceImpl();
		int page=1;
		Shops shop=(Shops) req.getSession().getAttribute("shops");
//		如果当前没有商家登录，跳转到登录界面
		if (shop == null) {
			resp.sendRedirect("login.jsp");
			return;
		}
		int sid=shop.getSid();
		String reqPage=req.getParameter("page");
		if (reqPage != null) {
			page=Integer.parseInt(reqPage);
		}
			int l=5;		//每页记录数
			int count=ds.getCountBySid(sid);
			int allPage=0;
//			计算总页数
			if(count%l==0) {
				allPage=count/l;
			}else {
				allPage=count/l+1;
			}
//			使page比总页数小，比负数大
			if (page>allPage) {
				page=allPage;
			} else if(page<1){
				page=0;
			}
//			将请求页码和总页数放入请求作用域返回
			 req.setAttribute("page", page);
			 req.setAttribute("allPage", allPage);
//			 按商家id分类分页查询药品并存入作用域
			 List<Drugs> drugs=ds.selectDrugsBySidLimit(sid,page,l);
			 List<Classify> classify=cs.findAllClassify();
			 req.setAttribute("classify", classify);
			 req.setAttribute("drugs", drugs);
			 req.getRequestDispatcher("./page/Shops/druglist.jsp").forward(req, resp);
	}

}
