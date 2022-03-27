package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.User;

public interface UserService {
//	用户登录
	User getLogin(String loginname, String password);
//	获取总记录数
	int getCount();
//	分页查询
	List<User> selectUserByLimit(int page, int l);
//	删除用户
	boolean deleteUser(String parameter);
//	模糊查询记录数
	int getCountBySearch(String searchu);
//	模糊查询分页
	List<User> searchByLimit(String searchu, int page, int l);
//	修改用户
	boolean updateUser(User u);
//	新增用户
	boolean addUser(User u);
//	查询所有用户
	List<User> findAllUser();
}
