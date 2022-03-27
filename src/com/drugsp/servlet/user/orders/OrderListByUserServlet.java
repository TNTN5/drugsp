package com.drugsp.servlet.user.orders;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;
import com.drugsp.service.DrugsService;
import com.drugsp.service.OrderService;
import com.drugsp.service.impl.DrugsServiceImpl;
import com.drugsp.service.impl.OrderServiceImpl;
/*
 * 按用户id查订单
 * */
@WebServlet("/orderbyuser.do")
public class OrderListByUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderService os=new OrderServiceImpl();
		DrugsService ds=new DrugsServiceImpl();
//		获取用户id，所有订单，所有商品
		int uid=Integer.parseInt(req.getParameter("uid"));
		List<Order> orders=os.findOrderByUid(uid);
		List<Drugs> drug=ds.findAlldrugs();
//		用户id，所有订单，所有商品存入作用域
		req.setAttribute("order", orders);
		req.setAttribute("drug", drug);
		req.setAttribute("uid", uid);
		
		req.getRequestDispatcher("page/User/orderbyuser.jsp").forward(req, resp);
	}

}
