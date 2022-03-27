package com.drugsp.service;

import com.drugsp.bean.Admin;

public interface AdminService {
//管理员登录
	Admin getLogin(String loginname, String password);

}
