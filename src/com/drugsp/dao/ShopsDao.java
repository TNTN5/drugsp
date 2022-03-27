package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.Shops;

public interface ShopsDao {

	Shops getLogin(String loginname, String password);

	int getCount();

	List<Shops> selectShopsBylimit(int b, int l);

	int getCountBySearch(String searchu);

	List<Shops> searchByLimit(String searchu, int b, int l);

	int deleteShops(int parseInt);

	int updateShops(Shops s);

	int AddShops(Shops s);

	List<Shops> findAllShops();

}
