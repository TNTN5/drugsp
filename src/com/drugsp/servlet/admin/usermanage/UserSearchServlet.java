package com.drugsp.servlet.admin.usermanage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drugsp.bean.User;
import com.drugsp.service.UserService;
import com.drugsp.service.impl.UserServiceImpl;
@WebServlet("/usersearch.do")
/*
 * 用户模糊查询
 * **/

public class UserSearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String searchu = req.getParameter("searchu");
	    UserService us=new UserServiceImpl();
	    
	    int page=1;				//当前页数
	    String reqPage=req.getParameter("page");
	    if (reqPage!=null) {
			page=Integer.parseInt(reqPage);
		}
	    int l=5;					//每页记录数
	    int count=us.getCountBySearch(searchu);
	    int allPage=0;
	    if (count%l==0) {
			allPage=count/l;
		} else {
			allPage=count/l+1;
		}
	    if (page>allPage) {
			page=allPage;
		} else if(page<1) {
			page=0;
		}
	    req.setAttribute("page", page);
	    req.setAttribute("allPage", allPage);
	    List<User> users= us.searchByLimit(searchu,page, l);
	    if(users!=null && users.size()>0) {
	    	System.out.println("查询成功");
	    	req.setAttribute("searchu", searchu);
	    	req.setAttribute("users", users);
		    req.getRequestDispatcher("./page/Admin/userlist.jsp").forward(req, resp);
	    }else {
	    	System.out.println("查询失败");
	    }
	}
}
