package com.drugsp.servlet.shops.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;
import com.drugsp.bean.Shops;
import com.drugsp.bean.User;
import com.drugsp.service.DrugsService;
import com.drugsp.service.OrderService;
import com.drugsp.service.ShopsService;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.DrugsServiceImpl;
import com.drugsp.service.impl.OrderServiceImpl;
import com.drugsp.service.impl.ShopsServiceImpl;
import com.drugsp.service.impl.UserServiceImpl;
@WebServlet("/orderbyshop.do")
/*
 * 商家查看订单
 * */
public class OrderListBySid extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		实例化service
		DrugsService ds=new DrugsServiceImpl();
		UserService us=new UserServiceImpl();
		OrderService os=new OrderServiceImpl();
		 int sid=Integer.parseInt(req.getParameter("sid"));
//			初始化page
		int page=1;
		String reqPage=req.getParameter("page");
//		如果页面传回的不为null，赋值给page
		if (reqPage != null) {
			page=Integer.parseInt(reqPage);
		}
			int l=5;	//每页记录数
			int count=os.getCountBySid(sid);
			int allPage=0;
//			计算总页数
			if(count%l==0) {
				allPage=count/l;
			}else {
				allPage=count/l+1;
			}
//			使page比总页数小，比负数大
			if (page>allPage) {
				page=allPage;
			} else if(page<1){
				page=0;
			}
//			将请求页码和全部页码放入作用域
			 req.setAttribute("page", page);
			 req.setAttribute("allPage", allPage);
//			 按商家id分类查订单
			 List<Order> order=os.selectOrderBySidLimit(sid,page,l);
//			 查所有的药品和用户，并放入作用域
			 List<Drugs> drugs=ds.findAlldrugs();
			 List<User> user=us.findAllUser();
			 req.setAttribute("order", order);
			 req.setAttribute("sid", sid);
			 req.setAttribute("user", user);
			 req.setAttribute("drugs", drugs);
			 req.getRequestDispatcher("./page/Shops/orderlist.jsp").forward(req, resp);
	}
	
}
