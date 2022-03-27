package com.drugsp.servlet.shops.drugmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Shops;
import com.drugsp.service.DrugsService;
import com.drugsp.service.impl.DrugsServiceImpl;
/*
 * 商家删除商品
 * *
 */

@WebServlet("/drugsdeletebyshop.do")
public class DrugDeleteByShop extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DrugsService ds=new DrugsServiceImpl();
		boolean bo= ds.deleteDrugs(req.getParameter("id"));
		if(bo) {
			 resp.sendRedirect("finddrugbysid.do");
		    }else {
		      System.out.println("删除失败");
		    }
	}
}
