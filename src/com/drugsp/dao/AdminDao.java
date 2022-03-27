package com.drugsp.dao;

import com.drugsp.bean.Admin;

public interface AdminDao {
//	管理员登录
	Admin getLogin(String loginname, String password);

}
