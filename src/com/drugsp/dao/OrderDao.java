package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;

public interface OrderDao {
//	分页查
	List<Order> selectOrderBylimit(int b, int l);
//	获取所有订单记录数
	int getCount();
//	获取模糊查询记录数
	int getCountBySearch(String searchu);
//	分页模糊查询
	List<Order> searchByLimit(String searchu, int b, int l);
//	删除商品时删除该商品产生的订单
	void deleteOrderByDid(int i);
//	删除用户时删除用户下的id
	void deleteOrderByUid(String id);
//	新增订单
	int addOrder(Drugs drug, int num, int uid);
//	按用户id查询订单
	List<Order> findOrderByUid(int uid);
//	修改订单完成时间   ps:用户确认收货
	int updateFinishTime(int oid);
//	按商家id获取记录数
	int getCountBySid(int sid);
//	商家id订单分页
	List<Order> searchBySidLimit(int sid, int b, int l);

}
