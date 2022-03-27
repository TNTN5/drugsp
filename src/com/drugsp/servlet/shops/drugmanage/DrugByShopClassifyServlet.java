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
/*
 * 商家按分类查看自己发布的商品
 * */
@WebServlet("/drugbyshopclassify.do")
public class DrugByShopClassifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DrugsService ds=new DrugsServiceImpl();
		ShopsService ss=new ShopsServiceImpl();
		ClassifyService cs=new ClassifyServiceImpl();
//		定义页码初始值
		int page=1;
//		获取session中的shops
		Shops shop=(Shops) req.getSession().getAttribute("shops");
//		如果为空，跳转登录页面
		if (shop == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		int sid=shop.getSid();
		String reqPage=req.getParameter("page");
		int cid=Integer.parseInt(req.getParameter("cid"));
		if (reqPage != null) {
			page=Integer.parseInt(reqPage);
		}
			int l=5;
			int count=ds.getCountBySidClassify(sid,cid);//分类下自己发布商品的总记录数
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
			 req.setAttribute("page", page);
			 req.setAttribute("allPage", allPage);
//			    商家按分类分页查看自己发布的药品
			 List<Drugs> drugs=ds.selectDrugsByClassifySidLimit(sid,cid,page,l);
			 List<Classify> classify=cs.findAllClassify();
			 req.setAttribute("classify", classify);
			 req.setAttribute("drugs", drugs);
			 req.setAttribute("cid", cid);
//			 跳转药品列表
			 req.getRequestDispatcher("page/Shops/druglist.jsp").forward(req, resp);
	}

}
