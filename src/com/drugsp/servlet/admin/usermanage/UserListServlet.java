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
/*
 *用户列表 
 **/
@WebServlet("/userlist.do")
public class UserListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService us=new UserServiceImpl();
		int page=1;
		String reqPage=req.getParameter("page");
		if (reqPage != null) {
			page=Integer.parseInt(reqPage);
		}
			int l=5;		//每页记录数
			int count=us.getCount();
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
//			将请求页码和总页数放入请求作用域返回
			 req.setAttribute("page", page);
			 req.setAttribute("allPage", allPage);
//			 分页查询用户并存入作用域
			 List<User> users=us.selectUserByLimit(page,l);
			 req.setAttribute("users", users);
			 req.getRequestDispatcher("./page/Admin/userlist.jsp").forward(req, resp);
	}
}
