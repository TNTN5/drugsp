package com.drugsp.servlet.user.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Message;
import com.drugsp.bean.Reply;
import com.drugsp.bean.Shops;
import com.drugsp.bean.User;
import com.drugsp.service.MessageService;
import com.drugsp.service.ReplyService;
import com.drugsp.service.ShopsService;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.MessageServiceImpl;
import com.drugsp.service.impl.ReplyServiceImpl;
import com.drugsp.service.impl.ShopsServiceImpl;
import com.drugsp.service.impl.UserServiceImpl;
/*
 * 留言列表
 * */
@WebServlet("/messagelisttouser.do")
public class MessageListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MessageService ms=new MessageServiceImpl();
		ReplyService rs=new ReplyServiceImpl();
		UserService us=new UserServiceImpl();
		ShopsService ss=new ShopsServiceImpl();
		List<Message> message=ms.findAllMessage();
		List<Reply> reply=rs.findAllReply();
		List<User> user=us.findAllUser();
		List<Shops> shop=ss.findAllShops();

		req.setAttribute("message", message);
		req.setAttribute("reply", reply);
		req.setAttribute("user", user);
		req.setAttribute("shop", shop);
		
		req.getRequestDispatcher("page/User/messagelist.jsp").forward(req, resp);
	}
}
