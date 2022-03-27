package com.drugsp.servlet.admin.shopsmanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Shops;
import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ShopsServiceImpl;
/*
 * 模糊查询商家
 * */
@WebServlet("/shopssearch.do")
public class ShopsSearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchu = req.getParameter("searchu");
	    ShopsService ss=new ShopsServiceImpl();
	    
	    int page=1;				//当前页数
	    String reqPage=req.getParameter("page");
	    if (reqPage!=null) {
			page=Integer.parseInt(reqPage);
		}
	    int l=5;					//每页记录数
	    int count=ss.getCountBySearch(searchu);
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
		} else if(page<1) {
			page=0;
		}
	    req.setAttribute("page", page);
	    req.setAttribute("allPage", allPage);
	    List<Shops> shops= ss.searchByLimit(searchu,page, l);
	    if(shops!=null && shops.size()>0) {
	    	System.out.println("查询成功");
	    	req.setAttribute("searchu", searchu);
	    	req.setAttribute("shops", shops);
		    req.getRequestDispatcher("./page/Admin/shopslist.jsp").forward(req, resp);
	    }else {
//	    	shops.size()<0时也要返回列表页面
	    	System.out.println("查询失败");
	    	req.setAttribute("searchu", searchu);
	    	req.setAttribute("shops", shops);
		    req.getRequestDispatcher("./page/Admin/shopslist.jsp").forward(req, resp);
	    }
	}
}
