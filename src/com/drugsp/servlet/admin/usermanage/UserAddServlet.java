package com.drugsp.servlet.admin.usermanage;

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
 * 新增用户
 * */
@WebServlet("/useradd.do")
public class UserAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		获取新增用户的属性值
		String username = req.getParameter("uname");
	    String password = req.getParameter("upassword");
	    String sex = req.getParameter("usex");
	    String realname = req.getParameter("urealname");
	    String age = req.getParameter("uage");
	    String tel = req.getParameter("utel");
	    User u=new User();
		u.setUname(username);
		u.setUpassword(password);
		u.setUrealname(realname);
		u.setUsex(sex);
		u.setUage(age);
		u.setUtel(tel);
//		新增
	    UserService us=new UserServiceImpl();
	    boolean bo= us.addUser(u);
	    if (bo) {
		    resp.sendRedirect("userlist.do");
		} else {
			System.out.println("添加失败");
		}
	}
	
}
