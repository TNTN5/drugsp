package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.User;
import com.drugsp.dao.UserDao;
import com.drugsp.util.DB_util;

public class UserDaoImpl implements UserDao{
	DB_util du=new DB_util();
	
	private List<User> mapToUser(String sql,Object[] obj){
		List<User> users=new ArrayList<>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			User u=new User();
			u.setUid(Integer.parseInt(m.get("u_id")));
			u.setUname(m.get("u_name"));
			u.setUpassword(m.get("u_password"));
			u.setUrealname(m.get("u_realname"));
			u.setUage(m.get("u_age"));
			u.setUsex(m.get("u_sex"));
			u.setUtel(m.get("u_tel"));
			users.add(u);
		}
		return users;
	}

	@Override
	public User getLogin(String loginname, String password) {
		String sql ="select * from d_user where u_name=?and u_password=?";
		Object[] obj = {loginname,password};
		List<User> user=mapToUser(sql, obj);
		if (user!=null&&user.size()>0) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int getCount() {
		String sql="select count(*) from d_user";
		List<Map<String, String>> list=du.select(sql, null);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}

	@Override
	public List<User> selectUserBylimit(int b, int l) {
		String sql ="SELECT * FROM d_user limit ? ,?";
		Object[] obj = {b,l};
		List<User> users=mapToUser(sql, obj);
		return users;
	}

	@Override
	public int deleteUser(int id) {
		String sql="delete from d_user where u_id=?";
        Object[] obj={id};
        int row=du.Update(sql,obj);
        return row;
	}

	@Override
	public int getCountBySearch(String searchu) {
		String sql="select count(*) from d_user where u_name like '%"+searchu+"%' union select count(*) from d_user where u_realname like '%"+searchu+"%' union  select count(*) from d_user where u_id like '%"+searchu+"%'";
		List<Map<String, String>> list=du.select(sql, null);
		int count =0;
		for (Map<String, String> map : list) {
			count+=Integer.parseInt(map.get("count(*)"));
		}
		return count;
	}

	@Override
	public List<User> searchByLimit(String searchu, int b, int l) {
		String sql ="select * from d_user where u_name like '%"+searchu+"%' union select * from d_user where u_realname like '%"+searchu+"%' union  select * from d_user where u_id like '%"+searchu+"%' limit ? ,?";
		Object[] obj = {b,l};
		List<User> users=mapToUser(sql, obj);
		return users;
	}

	@Override
	public int updateUser(User u) {
		String sql="update d_user set u_name=?,u_password=?,u_realname=?,u_sex=?,u_age=?,u_tel=? where u_id=?";
        Object[] obj={u.getUname(),u.getUpassword(),u.getUrealname(),u.getUsex(),u.getUage(),u.getUtel(),u.getUid()};
        int row=du.Update(sql,obj);
        return row;
	}

	@Override
	public int duplicateCheck(User u) {
		String sql="select * from d_user where u_name=?";
		Object[] obj= {u.getUname()};
		List<User> users=mapToUser(sql, obj);
		return users.size();
	}

	@Override
	public int addUser(User u) {
		 String sql="insert into d_user values(?,?,?,?,?,?,?)";
	     Object[] obj={null,u.getUname(),u.getUpassword(),u.getUrealname(),u.getUtel(),u.getUsex(),u.getUage()};
	     int row=du.Update(sql,obj);
	     return row;
	}

	@Override
	public List<User> findAllUser() {
		String sql="select * from d_user";
		List<User> users=mapToUser(sql, null);
		return users;
	}
	
}
