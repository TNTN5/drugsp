package com.drugsp.servlet.admin.usermanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.service.UserService;
import com.drugsp.service.impl.UserServiceImpl;
/*
 * 删除用户
 * */
@WebServlet("/userdelete.do")
public class UserDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		UserService us=new UserServiceImpl();
		boolean bo= us.deleteUser(req.getParameter("id"));
		if(bo) {
			 resp.sendRedirect("userlist.do");
		    }else {
		      resp.sendRedirect("index.jsp");
		    }
	}
}
