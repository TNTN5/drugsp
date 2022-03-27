package com.drugsp.servlet.shops.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.service.MessageService;
import com.drugsp.service.ReplyService;
import com.drugsp.service.impl.MessageServiceImpl;
import com.drugsp.service.impl.ReplyServiceImpl;
/*
 * 新增回复
 * */
@WebServlet("/replyadd.do")
public class ReplyAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyService rs=new ReplyServiceImpl();
//		获取商家id、留言id和回复的内容
		int sid=Integer.parseInt(req.getParameter("sid"));
		int mid=Integer.parseInt(req.getParameter("mid"));
		String content=req.getParameter("content");
		 boolean bo= rs.addReply(mid,sid,content);
		    if (bo) {
			    resp.sendRedirect("messagelisttoshop.do?id="+sid);
			} else {
				System.out.println("留言失败");
			}
	}
}
