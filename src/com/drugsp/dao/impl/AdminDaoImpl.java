package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Admin;
import com.drugsp.dao.AdminDao;
import com.drugsp.util.DB_util;

public class AdminDaoImpl implements AdminDao{
	DB_util du=new DB_util();
//将获取到的List<Map>转换成List<Admin>
	private List<Admin> mapToAdmin(String sql,Object[] obj){
		List<Admin> admins=new ArrayList<Admin>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			Admin a=new Admin();
			a.setAid(Integer.parseInt(m.get("a_id")));
			a.setAname(m.get("a_name"));
			a.setApassword(m.get("a_password"));
			admins.add(a);
		}
		return admins;
	}
	
//	登录
	@Override
	public Admin getLogin(String loginname, String password) {
		String sql ="select * from d_admin where a_name=?and a_password=?";
		Object[] obj = {loginname,password};
		List<Admin> admin=mapToAdmin(sql, obj);
		if (admin!=null&&admin.size()>0) {
			return admin.get(0);
		} else {
			return null;
		}
	}

}
