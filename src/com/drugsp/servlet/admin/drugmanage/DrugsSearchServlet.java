package com.drugsp.servlet.admin.drugmanage;

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
 * 管理员模糊查询药品
 * */
@WebServlet("/drugsearch.do")
public class DrugsSearchServlet extends HttpServlet{

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
	    int page=1;				//当前页数
	    String reqPage=req.getParameter("page");
	    if (reqPage!=null) {
			page=Integer.parseInt(reqPage);
		}
	    int l=5;					//每页记录数
	    int count=ds.getCountBySearch(searchu);	//获取符合条件的记录数
	    int allPage=0;
	    if (count%l==0) {		//计算总页数
			allPage=count/l;
		} else {
			allPage=count/l+1;
		}
	    if (page>allPage) {
			page=allPage;
		} else if(page<1) {
			page=0;
		}
//	    将page、allpage、商家、分类和药品写入requent作用域
	    req.setAttribute("page", page);
	    req.setAttribute("allPage", allPage);
		 List<Shops> shops=ss.findAllShops();
		 List<Classify> classify=cs.findAllClassify();
		 List<Drugs> drugs= ds.searchByLimit(searchu,page, l); //分页查找
		 req.setAttribute("shops", shops);
		 req.setAttribute("classify", classify);
		 
	    if(drugs!=null && drugs.size()>0) {
	    	System.out.println("查询成功");
	    	req.setAttribute("searchu", searchu);
	    	req.setAttribute("drugs", drugs);
		    req.getRequestDispatcher("page/Admin/druglist.jsp").forward(req, resp);
	    }else {
	    	 req.getRequestDispatcher("page/Admin/druglist.jsp").forward(req, resp);
	    }
	}

}
