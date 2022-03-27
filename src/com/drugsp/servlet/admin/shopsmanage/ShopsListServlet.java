package com.drugsp.servlet.admin.shopsmanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Shops;
import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ShopsServiceImpl;
/**
 * 商家列表
 * */
@WebServlet("/shopslist.do")
public class ShopsListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopsService ss=new ShopsServiceImpl();
		int page=1;
		String reqPage=req.getParameter("page");
		if (reqPage != null) {
			page=Integer.parseInt(reqPage);
		}
		//每页记录数
			int l=5;
			int count=ss.getCount();
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
//			为作用域赋属性值
			 req.setAttribute("page", page);
			 req.setAttribute("allPage", allPage);
			    
			 List<Shops> shops=ss.selectShopsByLimit(page,l);
			 req.setAttribute("shops", shops);
			 req.getRequestDispatcher("./page/Admin/shopslist.jsp").forward(req, resp);
	}
}
