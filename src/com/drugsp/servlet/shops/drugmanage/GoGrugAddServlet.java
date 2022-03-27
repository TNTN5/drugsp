package com.drugsp.servlet.shops.drugmanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Classify;
import com.drugsp.service.ClassifyService;
import com.drugsp.service.impl.ClassifyServiceImpl;
@WebServlet("/godrugadd.do")
/*
 * 跳转商家新增药品页面
 * 返回全部分类信息
 * */
public class GoGrugAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClassifyService cs=new ClassifyServiceImpl();
//		获取所有分类并存入作用域
		List<Classify> classify=cs.findAllClassify();
		req.setAttribute("classify", classify);
		req.getRequestDispatcher("page/Shops/drugadd.jsp").forward(req, resp);;
	}
}
