package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.Order;

public interface OrderService {
//分页查询
	List<Order> selectOrderByLimit(int page, int l);
//总记录数
	int getCount();
//模糊查询记录数
	int getCountBySearch(String searchu);
//模糊查询分页
	List<Order> searchByLimit(String searchu, int page, int l);
//按照用户id查寻订单
	List<Order> findOrderByUid(int uid);
//用户确认收货后修改订单完成时间
	boolean updateFinishTime(int oid);
//按商家id获取订单记录数
	int getCountBySid(int sid);
//	按商家id修改订单
	List<Order> selectOrderBySidLimit(int sid, int page, int l);

}
