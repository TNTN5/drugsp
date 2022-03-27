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
 * 新增商家
 * */
@WebServlet("/shopsadd.do")
public class ShopsAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		获取新增用户的属性值
		String sname = req.getParameter("sname");
	    String spassword = req.getParameter("spassword");
	    String srealname = req.getParameter("srealname");
	    String stel = req.getParameter("stel");
	    Shops s=new Shops();
		s.setSname(sname);
		s.setSpassword(spassword);
		s.setSrealname(srealname);
		s.setStel(stel);
//		新增
	    ShopsService ss=new ShopsServiceImpl();
	    boolean bo= ss.addShops(s);
	    if (bo) {
		    resp.sendRedirect("shopslist.do");
		} else {
			System.out.println("添加失败");
		}
	}
}
