package com.drugsp.service.impl;

import com.drugsp.bean.Admin;
import com.drugsp.dao.AdminDao;
import com.drugsp.dao.impl.AdminDaoImpl;
import com.drugsp.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDao ad=new AdminDaoImpl();
	@Override
	public Admin getLogin(String loginname, String password) {
		return ad.getLogin(loginname, password);
	}

}
