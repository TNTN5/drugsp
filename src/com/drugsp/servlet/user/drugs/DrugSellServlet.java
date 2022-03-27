package com.drugsp.servlet.user.drugs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Drugs;
import com.drugsp.service.DrugsService;
import com.drugsp.service.impl.DrugsServiceImpl;
@WebServlet("/drugsell.do")
/*
 * 用户购买商品
 * */
public class DrugSellServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DrugsService ds=new DrugsServiceImpl();
		int drugid=Integer.parseInt(req.getParameter("drugid"));
		int num=Integer.parseInt(req.getParameter("dnum"));
		int uid=Integer.parseInt(req.getParameter("uid"));
//		如果购买数量为0，直接返回
		if (num==0) {
			resp.sendRedirect("alldrug.do");
			return;
		}
		Drugs drug=ds.findDrugByid(drugid);
		//计算新的库存
 		drug.setStock(drug.getStock()-num);	
		boolean bo= ds.DrugsSell(drug,num,uid);
		if(bo) {
		  resp.sendRedirect("alldrug.do");
		}else {
		  resp.sendRedirect("alldrug.do");
		}
	}
}
