package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.User;

public interface UserDao {
//	用户登录
	User getLogin(String loginname, String password);
//	获取记录数
	int getCount();
//	分页查询
	List<User> selectUserBylimit(int b, int l);
//	删除用户
	int deleteUser(int parseInt);
//	模糊查询记录数
	int getCountBySearch(String searchu);
//	模糊查询分页
	List<User> searchByLimit(String searchu, int b, int l);
//	修改用户
	int updateUser(User u);
//	用户查重
	int duplicateCheck(User u);
//	新增用户
	int addUser(User u);
//	查询所有用户
	List<User> findAllUser();
}
