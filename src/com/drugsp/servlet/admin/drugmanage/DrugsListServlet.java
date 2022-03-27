package com.drugsp.servlet.admin.drugmanage;

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
 * 查看药品列表
 * **/
@WebServlet("/druglist.do")
public class DrugsListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		实例化service
		DrugsService ds=new DrugsServiceImpl();
		ShopsService ss=new ShopsServiceImpl();
		ClassifyService cs=new ClassifyServiceImpl();
		int page=1;
		String reqPage=req.getParameter("page");
//		如果页面传回的不为null，赋值给page
		if (reqPage != null) {	
			page=Integer.parseInt(reqPage);
		}
			int l=5;
			int count=ds.getCount();	//获取记录总数
			int allPage=0;
			if(count%l==0) {			//计算总页数
				allPage=count/l;
			}else {
				allPage=count/l+1;
			}
			if (page>allPage) {			//使页码不为负，且不大于总页数
				page=allPage;
			} else if(page<1){
				page=0;
			}
			 req.setAttribute("page", page);
			 req.setAttribute("allPage", allPage);
//			分页查询药品列表、查询所有商家和分类
			 List<Drugs> drugs=ds.selectDrugsByLimit(page,l);
			 List<Shops> shops=ss.findAllShops();
			 List<Classify> classify=cs.findAllClassify();
			 req.setAttribute("shops", shops);
			 req.setAttribute("classify", classify);
			 req.setAttribute("drugs", drugs);
//			 转发到药品列表页面
			 req.getRequestDispatcher("./page/Admin/druglist.jsp").forward(req, resp);
	}
	
}
