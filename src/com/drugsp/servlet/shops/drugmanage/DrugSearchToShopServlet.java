package com.drugsp.servlet.shops.drugmanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.Classify;
import com.drugsp.bean.Drugs;
import com.drugsp.bean.Shops;
import com.drugsp.service.ClassifyService;
import com.drugsp.service.DrugsService;
import com.drugsp.service.ShopsService;
import com.drugsp.service.impl.ClassifyServiceImpl;
import com.drugsp.service.impl.DrugsServiceImpl;
import com.drugsp.service.impl.ShopsServiceImpl;
/*
 * 商家模糊查询药品
 * */
@WebServlet("/drupsearchtoshop.do")
public class DrugSearchToShopServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchu = req.getParameter("searchu");
	    DrugsService ds=new DrugsServiceImpl();
	    ShopsService ss=new ShopsServiceImpl();
		ClassifyService cs=new ClassifyServiceImpl();
//		从session作用域中获取登录的商家信息
		Shops shop=(Shops) req.getSession().getAttribute("shops");
	    int page=1;				//当前页数
	    String reqPage=req.getParameter("page");
	    if (reqPage!=null) {
			page=Integer.parseInt(reqPage);
		}
	    int l=5;					//每页记录数
	    int count=ds.getCountBySearchSid(shop.getSid(),searchu);
	    int allPage=0;
//	    计算总页数
	    if (count%l==0) {
			allPage=count/l;
		} else {
			allPage=count/l+1;
		}
//		使page比总页数小，比负数大
	    if (page>allPage) {
			page=allPage;
		} else if(page<1) {
			page=0;
		}
//		将请求页码和总页数放入请求作用域返回
	    req.setAttribute("page", page);
	    req.setAttribute("allPage", allPage);
		 List<Shops> shops=ss.findAllShops();
		 List<Classify> classify=cs.findAllClassify();
//		 模糊分页查询药品并存入作用域
		 List<Drugs> drugs= ds.searchBySidLimit(shop.getSid(),searchu,page, l);
		 req.setAttribute("shops", shops);
	    if(drugs!=null && drugs.size()>0) {
	    	System.out.println("查询成功");
	    	req.setAttribute("classify", classify);
	    	req.setAttribute("searchu", searchu);
	    	req.setAttribute("drugs", drugs);
		    req.getRequestDispatcher("./page/Shops/druglist.jsp").forward(req, resp);
	    }else {
	    	req.setAttribute("searchu", searchu);
	    	 req.getRequestDispatcher("./page/Shops/druglist.jsp").forward(req, resp);
	    }
	}

}
