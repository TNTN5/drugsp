package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Message;
import com.drugsp.bean.User;
import com.drugsp.dao.MessageDao;
import com.drugsp.dao.OrderDao;
import com.drugsp.dao.ReplyDao;
import com.drugsp.dao.UserDao;
import com.drugsp.dao.impl.MessageDaoImpl;
import com.drugsp.dao.impl.OrderDaoImpl;
import com.drugsp.dao.impl.ReplyDaoImpl;
import com.drugsp.dao.impl.UserDaoImpl;
import com.drugsp.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao ud=new UserDaoImpl();
	@Override
	public User getLogin(String loginname, String password) {
		return ud.getLogin(loginname, password);
	}
	@Override
	public int getCount() {
		int count =ud.getCount();
		return count;
	}
	@Override
	public List<User> selectUserByLimit(int page, int l) {
		int b=(page-1)*l;
		List<User> list= ud.selectUserBylimit(b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public boolean deleteUser(String id) {
		int row=ud.deleteUser(Integer.parseInt(id));
		OrderDao od=new OrderDaoImpl();
		MessageDao md=new MessageDaoImpl();
		ReplyDao rd=new ReplyDaoImpl();
//		查找用户发布的所有留言
		List<Message> mlist=md.findMessageByUid(id);
		for (Message m : mlist) {
//			删除所有留言和留言下的回复
			md.deleteMessage(m.getMid());
			rd.deleteReplyByMid(m.getMid());
		}
		od.deleteOrderByUid(id);
        if (row!=0){
            return true;
        }else {	
            return false;
        }
	}
	@Override
	public int getCountBySearch(String searchu) {
//		如果搜索框内容为null 使搜索内容为空字符串
		if (searchu==null) {
			searchu="";
		}
		int count =ud.getCountBySearch(searchu);
		return count;
	}
	@Override
	public List<User> searchByLimit(String searchu, int page, int l) {
		int b=(page-1)*l;
//		如果分页开始索引为负数，将其改变为0；
		if (b<0) {
			b=0;
		}
		if (searchu==null) {
			searchu="";
		}
		List<User> list= ud.searchByLimit(searchu,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public boolean updateUser(User u) {
		int row=ud.updateUser(u);
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}
	@Override
	public boolean addUser(User u) {
//		查重，如果用户名已经存在则不允许在新增
		int dr = ud.duplicateCheck(u);
        if(dr>0) {
        	System.out.println("用户已存在");
        	return false;
        }
        int urow=ud.addUser(u);
        if (urow>0){
        	return true;
        }else{
            return false;
        }
	}
	@Override
	public List<User> findAllUser() {
		return ud.findAllUser();
	}
}
