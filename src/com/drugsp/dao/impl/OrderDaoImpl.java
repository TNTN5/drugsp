package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;
import com.drugsp.dao.OrderDao;
import com.drugsp.util.DB_util;

public class OrderDaoImpl implements OrderDao{
DB_util du =new DB_util();

	private List<Order> mapToOrders(String sql,Object[] obj){
		List<Order> orders=new ArrayList<>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			Order o=new Order();
			o.setOid(Integer.parseInt(m.get("o_id")));
			o.setDrugid(Integer.parseInt(m.get("d_id")));
			o.setSid(Integer.parseInt(m.get("s_id")));
			o.setUid(Integer.parseInt(m.get("u_id")));
			o.setOcreatetime(m.get("o_createtime"));
			o.setO_finishtime((m.get("o_finishtime")));
			o.setDnum(Integer.parseInt(m.get("d_num")));
			orders.add(o);
		}
		return orders;
	}
	@Override
	public List<Order> selectOrderBylimit(int b, int l) {
		String sql ="SELECT * FROM d_order limit ? ,?";
		Object[] obj = {b,l};
		List<Order> order=mapToOrders(sql, obj);
		return order;
	}

	@Override
	public int getCount() {
		String sql="select count(*) from d_order";
		List<Map<String, String>> list=du.select(sql, null);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}
	@Override
	public int getCountBySearch(String searchu) {
		String sql="select count(*) from d_order o left join d_user u on o.u_id=u.u_id where u.u_name like '%"+searchu+"%' union select count(*) from d_order o left join d_shops s on o.s_id=s.s_id where s.s_name like '%"+searchu+"%' union select count(*) from d_order o left join d_drugs d on o.d_id=d.d_id where d.d_name like '%"+searchu+"%'";
		List<Map<String, String>> list=du.select(sql, null);
		int count =0;
		for (Map<String, String> map : list) {
			count+=Integer.parseInt(map.get("count(*)"));
		}
		return count;
	}
	@Override
	public List<Order> searchByLimit(String searchu, int b, int l) {
		String sql="select o.* from d_order o left join d_user u on o.u_id=u.u_id where u.u_name like '%"+searchu+"%' union select o.* from d_order o left join d_shops s on o.s_id=s.s_id where s.s_name like '%"+searchu+"%' union select o.* from d_order o left join d_drugs d on o.d_id=d.d_id where d.d_name like '%"+searchu+"%' limit ?,?";
		Object[] obj = {b,l};
		List<Order> order=mapToOrders(sql, obj);
		return order;
	}
	@Override
	public void deleteOrderByDid(int id) {
		String sql="delete from d_order where d_id=?";
        Object[] obj={id};
        int row=du.Update(sql,obj);
        System.out.println(row);
	}
	@Override
	public void deleteOrderByUid(String id) {
		String sql="delete from d_order where u_id=?";
        Object[] obj={id};
        int row=du.Update(sql,obj);
	}
	@Override
	public int addOrder(Drugs drug, int num, int uid) {
		String sql="insert into d_order values(?,?,?,?,?,now(),?)";
		System.out.println(drug.getSid());
        Object[] obj={null,drug.getDrugid(),num,drug.getSid(),uid,null};
        return du.Update(sql,obj);
	}
	@Override
	public List<Order> findOrderByUid(int uid) {
		String sql="select * from d_order where u_id =?";
        Object[] obj={uid};
        return mapToOrders(sql, obj);
	}
	@Override
	public int updateFinishTime(int oid) {
		String sql ="update d_order set o_finishtime=now() where o_id=?";
		Object[] obj= {oid};
		return du.Update(sql, obj);
	}
	@Override
	public int getCountBySid(int sid) {
		String sql="select count(*) from d_order where s_id=?";
		Object[] obj= {sid};
		List<Map<String, String>> list=du.select(sql, obj);
		int count =0;
		for (Map<String, String> map : list) {
			count+=Integer.parseInt(map.get("count(*)"));
		}
		return count;
	}
	@Override
	public List<Order> searchBySidLimit(int sid, int b, int l) {
		String sql="select * from d_order where s_id=? order by o_createtime desc limit ?,?";
		Object[] obj = {sid,b,l};
		List<Order> order=mapToOrders(sql, obj);
		return order;
	}

}
