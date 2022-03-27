package com.drugsp.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Admin;
import com.drugsp.service.AdminService;
import com.drugsp.service.impl.AdminServiceImpl;
import com.google.code.kaptcha.Constants;
/*
 * 管理员登录
 * */
@WebServlet("/adminlogin.do")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService as=new AdminServiceImpl();
		String loginname= req.getParameter("loginname");
		String password= req.getParameter("password");
		String yzm= req.getParameter("yzm");
//		获取验证码图片上的字符串
		String kaptcha=(String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//		如果验证码错误返回登录页面
		if (yzm.equals(kaptcha)) {
			Admin a=as.getLogin(loginname, password);
//		如果没有查到管理员信息，即密码或账号错误则返回登录页面
			if (a!=null) {
				req.getSession().setAttribute("admin", a);
				resp.sendRedirect("page/Admin/aindex.jsp");
			} else {
				System.out.println("账号密码错误");
				req.setAttribute("msg", "账号密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {
			System.out.println("验证码错误");
			req.setAttribute("msg", "验证码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
