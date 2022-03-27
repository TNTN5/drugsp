package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;
import com.drugsp.dao.OrderDao;
import com.drugsp.dao.impl.OrderDaoImpl;
import com.drugsp.service.OrderService;

public class OrderServiceImpl implements OrderService{
OrderDao od =new OrderDaoImpl();
	@Override
	public List<Order> selectOrderByLimit(int page, int l) {
		int b=(page-1)*l;
		if (b<0) {
			b=0;
		}
		List<Order> list= od.selectOrderBylimit(b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public int getCount() {
		int count =od.getCount();
		return count;
	}

	@Override
	public int getCountBySearch(String searchu) {
		if (searchu==null) {
			searchu="";
		}
		int count =od.getCountBySearch(searchu);
		return count;
	}

	@Override
	public List<Order> searchByLimit(String searchu, int page, int l) {
		int b=(page-1)*l;
		if (b<0) {
			b=0;
		}
		if (searchu==null) {
			searchu="";
		}
		List<Order> list= od.searchByLimit(searchu,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public List<Order> findOrderByUid(int uid) {
		return od.findOrderByUid(uid);
	}

	@Override
	public boolean updateFinishTime(int oid) {
		int row=od.updateFinishTime(oid);
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}

	@Override
	public int getCountBySid(int sid) {
		int count =od.getCountBySid(sid);
		return count;
	}

	@Override
	public List<Order> selectOrderBySidLimit(int sid, int page, int l) {
		int b=(page-1)*l;
		List<Order> list= od.searchBySidLimit(sid,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

}
