package com.drugsp.servlet.admin.drugmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.service.DrugsService;
import com.drugsp.service.impl.DrugsServiceImpl;
/*
 * 管理员删除药品
 * */
@WebServlet("/drugsdelete.do")
public class DrugsDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		多态 实例化DrugsService
		DrugsService ds=new DrugsServiceImpl();
//		按id删除药品
		boolean bo= ds.deleteDrugs(req.getParameter("id"));
		if(bo) {
//			如果删除成功则重定向到查询所有药品
			 resp.sendRedirect("druglist.do");
		    }else {
		      resp.sendRedirect("index.jsp");
		    }
	}

}
