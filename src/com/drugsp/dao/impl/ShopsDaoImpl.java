package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Admin;
import com.drugsp.bean.Shops;
import com.drugsp.bean.User;
import com.drugsp.dao.ShopsDao;
import com.drugsp.util.DB_util;

public class ShopsDaoImpl implements ShopsDao{
	DB_util du=new DB_util();
	
	private List<Shops> mapToShops(String sql,Object[] obj){
		List<Shops> shops=new ArrayList<>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			Shops s=new Shops();
			s.setSid(Integer.parseInt(m.get("s_id")));
			s.setSname(m.get("s_name"));
			s.setSpassword(m.get("s_password"));
			s.setSrealname(m.get("s_realname"));
			s.setStel(m.get("s_tel"));
			shops.add(s);
		}
		return shops;
	}

	@Override
	public Shops getLogin(String loginname, String password) {
		String sql ="select * from d_shops where s_name=?and s_password=?";
		Object[] obj = {loginname,password};
		List<Shops> shop=mapToShops(sql, obj);
		if (shop!=null&&shop.size()>0) {
			return shop.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int getCount() {
		String sql="select count(*) from d_shops";
		List<Map<String, String>> list=du.select(sql, null);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}

	@Override
	public List<Shops> selectShopsBylimit(int b, int l) {
		String sql ="SELECT * FROM d_shops limit ? ,?";
		Object[] obj = {b,l};
		List<Shops> shops=mapToShops(sql, obj);
		return shops;
	}

	@Override
	public int getCountBySearch(String searchu) {
		String sql="select count(*) from d_shops where s_name like '%"+searchu+"%' union select count(*) from d_shops where s_realname like '%"+searchu+"%' union  select count(*) from d_shops where s_id like '%"+searchu+"%'";
		List<Map<String, String>> list=du.select(sql, null);
		int count =0;
		for (Map<String, String> map : list) {
			count+=Integer.parseInt(map.get("count(*)"));
		}
		return count;
	}

	@Override
	public List<Shops> searchByLimit(String searchu, int b, int l) {
		String sql ="select * from d_shops where s_name like '%"+searchu+"%' union select * from d_shops where s_realname like '%"+searchu+"%' union  select * from d_shops where s_id like '%"+searchu+"%' limit ? ,?";
		Object[] obj = {b,l};
		List<Shops> shops=mapToShops(sql, obj);
		return shops;
	}

	@Override
	public int deleteShops(int id) {
		String sql="delete from d_shops where s_id=?";
        Object[] obj={id};
        int row=du.Update(sql,obj);
        return row;
	}

	@Override
	public int updateShops(Shops s) {
		String sql="update d_shops set s_name=?,s_password=?,s_realname=?,s_tel=? where s_id=?";
        Object[] obj={s.getSname(),s.getSpassword(),s.getSrealname(),s.getStel(),s.getSid()};
        int row=du.Update(sql,obj);
        return row;
	}

	@Override
	public int AddShops(Shops s) {
		 String sql="insert into d_shops values(?,?,?,?,?)";
	     Object[] obj={null,s.getSname(),s.getSpassword(),s.getSrealname(),s.getStel()};
	     int row=du.Update(sql,obj);
	     return row;
	}

	@Override
	public List<Shops> findAllShops() {
		String sql ="select * from d_shops";
		List<Shops> shops=mapToShops(sql, null);
		return shops;
	}
}
