package com.drugsp.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.User;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.UserServiceImpl;
import com.google.code.kaptcha.Constants;
/*
 * 用户登录
 * */
@WebServlet("/userlogin.do")
public class UserLoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService us=new UserServiceImpl();
//		获取用户名，密码，验证码
		String loginname= req.getParameter("loginname");
		String password= req.getParameter("password");
		String yzm= req.getParameter("yzm");
//		获取正确的验证码字符
		String kaptcha=(String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (yzm.equals(kaptcha)) {//验证码正确
			User u=us.getLogin(loginname, password);
			if (u!=null) {//账号密码正确
				req.getSession().setAttribute("user", u);
				resp.sendRedirect("page/User/uindex.jsp");
			} else {//账号密码错误
				req.setAttribute("msg", "账号密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {//验证码错误
			req.setAttribute("msg", "验证码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
