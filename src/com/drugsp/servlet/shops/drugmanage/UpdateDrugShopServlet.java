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
 * 商家修改药品
 * **/
@WebServlet("/drugsupdatebyshop.do")
public class UpdateDrugShopServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Drugs d =new Drugs();
//		获取修改后的药品信息
		d.setDrugid(Integer.parseInt(req.getParameter("drugid")));
		d.setDname(req.getParameter("dname"));
		d.setDecpict(req.getParameter("decpict"));
		d.setDprice(Double.parseDouble(req.getParameter("dprice")));
//		从session获取shops,并将sid赋给药品的sid
		Shops shop=(Shops) req.getSession().getAttribute("shops");
		d.setSid(shop.getSid());
		d.setCid(Integer.parseInt(req.getParameter("classify")));
		d.setStock(Integer.parseInt(req.getParameter("stock")));
		DrugsService ds=new DrugsServiceImpl();
		boolean bo= ds.updateDrugs(d);
		if(bo) {
		  resp.sendRedirect("finddrugbysid.do");
		}else {
		  resp.sendRedirect("finddrugbysid.do");
		}
	}
	
}
