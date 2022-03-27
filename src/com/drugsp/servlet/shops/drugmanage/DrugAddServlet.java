package com.drugsp.servlet.shops.drugmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Shops;
import com.drugsp.service.DrugsService;
import com.drugsp.service.impl.DrugsServiceImpl;
/*
 * 新增药品
 * */
@WebServlet("/drugadd.do")
public class DrugAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DrugsService ds=new DrugsServiceImpl();
//		从session作用域获取登录商家信息
		Shops shop=(Shops)req.getSession().getAttribute("shops");
//		如果商家信息为空，跳转登录页面，并跳出servlet方法
		if (shop == null) {
			resp.sendRedirect("login.jsp");
			return;
		}
//		获取新增药品的属性值
		Drugs d=new Drugs();
		d.setDecpict(req.getParameter("decpict"));
		d.setDname(req.getParameter("dname"));
		d.setDprice(Double.parseDouble(req.getParameter("dprice")));
		d.setCid(Integer.parseInt(req.getParameter("classify")));
		d.setSid(shop.getSid());
		d.setStock(Integer.parseInt(req.getParameter("stock")));
//		新增商品
		 boolean bo= ds.addDrug(d);
		    if (bo) {
			    resp.sendRedirect("finddrugbysid.do");
			} else {
				System.out.println("添加失败");
			}
	}

}
