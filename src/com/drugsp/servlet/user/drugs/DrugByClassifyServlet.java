package com.drugsp.servlet.user.drugs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Classify;
import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;
import com.drugsp.bean.Shops;
import com.drugsp.bean.User;
import com.drugsp.service.ClassifyService;
import com.drugsp.service.DrugsService;
import com.drugsp.service.OrderService;
import com.drugsp.service.ShopsService;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.ClassifyServiceImpl;
import com.drugsp.service.impl.DrugsServiceImpl;
import com.drugsp.service.impl.OrderServiceImpl;
import com.drugsp.service.impl.ShopsServiceImpl;
import com.drugsp.service.impl.UserServiceImpl;
@WebServlet("/drugbyclassify.do")
/*
 * 按分类查商品
 * */
public class DrugByClassifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("cid").equals("0")) {
			 req.setAttribute("classify", 0);
			req.getRequestDispatcher("drupsearchtouser.do").forward(req, resp);
			return;
		}
		int classify = Integer.parseInt(req.getParameter("cid"));
	    DrugsService ds=new DrugsServiceImpl();
	    ShopsService ss=new ShopsServiceImpl();
	    int page=1;				//		初始化page
	    String reqPage=req.getParameter("page");
//		如果页面传回的不为null，赋值给page
	    if (reqPage!=null) {
			page=Integer.parseInt(reqPage);
		}
	    int l=5;					//每页记录数
	    int count=ds.getCountByClassify(classify);
	    int allPage=0;
//		计算总页数
	    if (count%l==0) {
			allPage=count/l;
		} else {
			allPage=count/l+1;
		}
//		使page比总页数小，比负数大
	    if (page>allPage) {
			page=allPage;
		} else if(page<0) {
			page=0;
		}
	    req.setAttribute("page", page);
	    req.setAttribute("allPage", allPage);
		 List<Shops> shops=ss.findAllShops();
//		 分类分页查询药品
		 List<Drugs> drugs= ds.selectDrugsByClassifyLimit(classify,page, l);
		 req.setAttribute("shops", shops);
		 req.setAttribute("classify", classify);
	    if(drugs!=null && drugs.size()>0) {
	    	System.out.println("查询成功");
	    	req.setAttribute("drugs", drugs);
		    req.getRequestDispatcher("page/User/druglist.jsp").forward(req, resp);
	    }else {
	    	 req.getRequestDispatcher("page/User/druglist.jsp").forward(req, resp);
	    }
	}
}
