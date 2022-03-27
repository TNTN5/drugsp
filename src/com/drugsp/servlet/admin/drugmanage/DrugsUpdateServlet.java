package com.drugsp.servlet.admin.drugmanage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Drugs;
import com.drugsp.service.DrugsService;
import com.drugsp.service.impl.DrugsServiceImpl;
/*
 * 管理员修改药品
 * */
@WebServlet("/drugsupdate.do")
public class DrugsUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Drugs d =new Drugs();
//		获取改变后的值
		d.setDrugid(Integer.parseInt(req.getParameter("drugid")));
		d.setDname(req.getParameter("dname"));
		d.setDecpict(req.getParameter("decpict"));
		d.setDprice(Double.parseDouble(req.getParameter("dprice")));
		d.setSid(Integer.parseInt(req.getParameter("shops")));
		d.setCid(Integer.parseInt(req.getParameter("classify")));
		d.setStock(Integer.parseInt(req.getParameter("stock")));
		DrugsService ds=new DrugsServiceImpl();
//		修改药品信息
		boolean bo= ds.updateDrugs(d);
		if(bo) {
		  resp.sendRedirect("druglist.do");
		}else {
		  resp.sendRedirect("druglist.do");
		}
	}
	
}
