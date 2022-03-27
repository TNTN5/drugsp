package com.drugsp.servlet.shops;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Shops;
import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ShopsServiceImpl;
import com.google.code.kaptcha.Constants;
@WebServlet("/shopslogin.do")
/*
 * 商家登录
 * */
public class ShopsLoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopsService ss=new ShopsServiceImpl();
//		获取商家登录用户名，密码，验证码
		String loginname= req.getParameter("loginname");
		String password= req.getParameter("password");
		String yzm= req.getParameter("yzm");
		String kaptcha=(String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (yzm.equals(kaptcha)) {//验证码正确
			Shops s=ss.getLogin(loginname, password);
			if (s!=null) {//账号密码正确
				req.getSession().setAttribute("shops", s);
				resp.sendRedirect("page/Shops/sindex.jsp");
			} else {//账号密码错误
				req.setAttribute("msg", "账号密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {	//验证码错误
			req.setAttribute("msg", "验证码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
