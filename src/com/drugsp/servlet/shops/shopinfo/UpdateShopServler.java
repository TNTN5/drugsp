package com.drugsp.servlet.shops.shopinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Shops;
import com.drugsp.bean.User;
import com.drugsp.service.ShopsService;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.ShopsServiceImpl;
import com.drugsp.service.impl.UserServiceImpl;
/*
 * 商家修改药品信息
 * */
@WebServlet("/shopupdatefromshop.do")
public class UpdateShopServler extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Shops s =new Shops();
		s.setSid(Integer.parseInt(req.getParameter("sid")));
		s.setSname(req.getParameter("sname"));
		s.setSpassword(req.getParameter("spassword"));
		s.setSrealname(req.getParameter("srealname"));
		s.setStel(req.getParameter("stel"));
		ShopsService ss=new ShopsServiceImpl();
		boolean bo= ss.updateShops(s);
		if(bo) {
		  resp.sendRedirect("login.jsp");
		}else {
		  resp.sendRedirect("login.jsp");
		}
	}
	
}
