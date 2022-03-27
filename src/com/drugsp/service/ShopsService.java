package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.Shops;

public interface ShopsService {
//	商家登录
	Shops getLogin(String loginname, String password);
//	获取商家记录数
	int getCount();
//	分页查商家
	List<Shops> selectShopsByLimit(int page, int l);
//	模糊查询记录数
	int getCountBySearch(String searchu);
//	模糊查询分页
	List<Shops> searchByLimit(String searchu, int page, int l);
//	删除商家
	boolean deleteShops(String parameter);
//	修改商家
	boolean updateShops(Shops s);
//	新增商家
	boolean addShops(Shops s);
//	查询所有商家
	List<Shops> findAllShops();

}
