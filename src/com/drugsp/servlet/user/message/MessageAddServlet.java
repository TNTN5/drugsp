package com.drugsp.servlet.user.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.User;
import com.drugsp.service.MessageService;
import com.drugsp.service.impl.MessageServiceImpl;
@WebServlet("/messageadd.do")
/*
 * 新增留言
 * */
public class MessageAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MessageService ms=new MessageServiceImpl();
//		从session作用域中获取user，如果为空，显示需要登录
		User u=(User) req.getSession().getAttribute("user");
		if (u == null) {
			resp.sendRedirect("needlogin.jsp");
			return;
		}
//		获取用户id和发布的留言内容，并添加留言
		int uid=u.getUid();
		String content=req.getParameter("content");
		 boolean bo= ms.addMessage(uid,content);
		    if (bo) {
			    resp.sendRedirect("messagelisttouser.do?id="+uid);
			} else {
				System.out.println("留言失败");
			}
	}
}
