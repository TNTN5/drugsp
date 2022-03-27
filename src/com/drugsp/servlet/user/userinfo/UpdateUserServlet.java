package com.drugsp.servlet.user.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.User;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.UserServiceImpl;
/*
 * 修改用户信息
 * */
@WebServlet("/userupdatefromuser.do")
public class UpdateUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u =new User();
//		获取修改后的user属性值
		u.setUid(Integer.parseInt(req.getParameter("uid")));
		u.setUname(req.getParameter("uname"));
		u.setUpassword(req.getParameter("upassword"));
		u.setUrealname(req.getParameter("urealname"));
		u.setUsex(req.getParameter("usex"));
		u.setUage(req.getParameter("uage"));
		u.setUtel(req.getParameter("utel"));
		UserService us=new UserServiceImpl();
		boolean bo= us.updateUser(u);
		if(bo) {
		  resp.sendRedirect("login.jsp");
		}else {
		  resp.sendRedirect("login.jsp");
		}
	}
}
