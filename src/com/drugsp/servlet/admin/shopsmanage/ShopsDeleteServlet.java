package com.drugsp.servlet.admin.shopsmanage;

import java.io.IOException;
/*
 * 删除商家
 * */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ShopsServiceImpl;
/*
 * 删除商家
 * **/
@WebServlet("/shopsdelete.do")
public class ShopsDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopsService ss=new ShopsServiceImpl();
		boolean bo= ss.deleteShops(req.getParameter("id"));
		if(bo) {
			 resp.sendRedirect("shopslist.do");
		    }else {
		      resp.sendRedirect("index.jsp");
		    }
	}
	
}
