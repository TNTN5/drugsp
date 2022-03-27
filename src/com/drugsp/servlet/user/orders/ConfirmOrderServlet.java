package com.drugsp.servlet.user.orders;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.service.OrderService;
import com.drugsp.service.impl.OrderServiceImpl;
@WebServlet("/confirmorder.do")
/*
 * 用户点击确认收货，修改订单完成时间
 ***/
public class ConfirmOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderService os= new OrderServiceImpl();
//		获取用户id和订单id
		int oid=Integer.parseInt(req.getParameter("oid"));
		int uid=Integer.parseInt(req.getParameter("uid"));
		boolean bo= os.updateFinishTime(oid);
		if(bo) {
		  resp.sendRedirect("orderbyuser.do?uid="+uid);
		}else {
		  resp.sendRedirect("orderbyuser.do?uid="+uid);
		}
	}

}
