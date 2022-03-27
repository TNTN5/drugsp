package com.drugsp.servlet.admin.shopsmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Shops;
import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ShopsServiceImpl;
/*
 * 修改商家信息
 * */
@WebServlet("/shopsupdate.do")
public class ShopsUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		获取修改后商家的属性值
		Shops s =new Shops();
		s.setSid(Integer.parseInt(req.getParameter("sid")));
		s.setSname(req.getParameter("sname"));
		s.setSpassword(req.getParameter("spassword"));
		s.setSrealname(req.getParameter("srealname"));
		s.setStel(req.getParameter("stel"));
//		修改商家
		ShopsService ss=new ShopsServiceImpl();
		boolean bo= ss.updateShops(s);
		if(bo) {
		  resp.sendRedirect("shopslist.do");
		}else {
		  resp.sendRedirect("shopslist.do");
		}
	}
	
}
