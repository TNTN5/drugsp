package com.drugsp.servlet.admin.ordermanage;

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
/*
 * 订单模糊查询
 * */
@WebServlet("/ordersearch.do")
public class OrderSearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchu = req.getParameter("searchu");
	    DrugsService ds=new DrugsServiceImpl();
	    ShopsService ss=new ShopsServiceImpl();
	    UserService us=new UserServiceImpl();
		OrderService os =new OrderServiceImpl();
	    int page=1;				//当前页数
	    String reqPage=req.getParameter("page");
	    if (reqPage!=null) {
			page=Integer.parseInt(reqPage);
		}
	    int l=5;					//每页记录数
	    int count=os.getCountBySearch(searchu);
	    
	    int allPage=0;
	    if (count%l==0) {		//计算总页数
			allPage=count/l;
		} else {
			allPage=count/l+1;	
		}
	    if (page>allPage) {		//使当前页数不比总页数大，不比0小
			page=allPage;
		} else if(page<1) {
			page=0;
		}
	    req.setAttribute("page", page);
	    req.setAttribute("allPage", allPage);
//	    如果总记录数为0，直接返回页面
	    if (count==0) {
	    	req.getRequestDispatcher("page/Admin/orderlist.jsp").forward(req, resp);
	    	return;
		}
//	    查询所有商家、所有用户、所有药品、符合条件的订单
	    List<Shops> shops=ss.findAllShops();
	    List<User> user=us.findAllUser();
		List<Drugs> drugs= ds.findAlldrugs();
		List<Order> order=os.searchByLimit(searchu,page, l);
		 
	    if(drugs!=null && drugs.size()>0) {
	    	System.out.println("查询成功");
//		    将所有商家、所有用户、所有药品、符合条件的订单和搜索内容写入作用域
	    	req.setAttribute("drugs",drugs);
	    	req.setAttribute("shops",shops);
			 req.setAttribute("user",user);
			 req.setAttribute("order",order);
	    	req.setAttribute("searchu", searchu);
		    req.getRequestDispatcher("page/Admin/orderlist.jsp").forward(req, resp);
	    }else {
	    	 req.getRequestDispatcher("page/Admin/orderlist.jsp").forward(req, resp);
	    }
	}

}
