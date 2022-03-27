package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.User;
import com.drugsp.dao.DrugsDao;
import com.drugsp.util.DB_util;

public class DrugsDaoImpl implements DrugsDao{
DB_util du=new DB_util();
//将获取到的List<Map>转换成List<Drugs>
	private List<Drugs> mapToDrugs(String sql,Object[] obj){
		List<Drugs> drugs=new ArrayList<>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			Drugs d=new Drugs();
			d.setDrugid(Integer.parseInt(m.get("d_id")));
			d.setDname(m.get("d_name"));
			d.setDprice(Double.parseDouble(m.get("d_price")));
			d.setDecpict(m.get("d_decpict"));
			d.setCid(Integer.parseInt(m.get("c_id")));
			d.setSid(Integer.parseInt(m.get("s_id")));
			d.setStock(Integer.parseInt(m.get("d_stock")));
			drugs.add(d);
		}
		return drugs;
	}
	
//	获取记录数
	@Override
	public int getCount() {
		String sql="select count(*) from d_drugs";
		List<Map<String, String>> list=du.select(sql, null);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}
//分页搜索全部药品
	@Override
	public List<Drugs> selectDrugsBylimit(int b, int l) {
		String sql ="SELECT * FROM d_drugs limit ? ,?";
		Object[] obj = {b,l};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}
//	删除药品
	@Override
	public int deleteDrugs(int id) {
		String sql="delete from d_drugs where d_id=?";
        Object[] obj={id};
        int row=du.Update(sql,obj);
        return row;
	}
	
//	按照输入的信息模糊查询匹配的记录数
	@Override
	public int getCountBySearch(String searchu) {
		String sql="select count(*) from d_drugs where d_name like '%"+searchu+"%' union select count(*) from d_drugs where d_decpict like '%"+searchu+"%' union  select count(*) from d_drugs where d_id like '%"+searchu+"%'";
		List<Map<String, String>> list=du.select(sql, null);
		int count =0;
		for (Map<String, String> map : list) {
			count+=Integer.parseInt(map.get("count(*)"));
		}
		return count;
	}
//	按照输入的信息模糊查询分页查询
	@Override
	public List<Drugs> searchByLimit(String searchu, int b, int l) {
		String sql="select * from d_drugs where d_name like '%"+searchu+"%' union select * from d_drugs where d_decpict like '%"+searchu+"%' union  select * from d_drugs where d_id like '%"+searchu+"%' limit ?,?";
		Object[] obj = {b,l};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}
//	修改药品信息
	@Override
	public int updateDrugs(Drugs d) {
		String sql="update d_drugs set d_name=?,d_price=?,d_decpict=?,c_id=?,s_id=?,d_stock=? where d_id=?";
        Object[] obj={d.getDname(),d.getDprice(),d.getDecpict(),d.getCid(),d.getSid(),d.getStock(),d.getDrugid()};
        int row=du.Update(sql,obj);
        return row;
	}
	
//	查找所有药品
	@Override
	public List<Drugs> findAllDrugs() {
		String sql="select * from d_drugs";
		List<Drugs> drugs=mapToDrugs(sql, null);
		return drugs;
	}
//	按照商家id进行查询
	@Override
	public List<Drugs> findDrugsBySid(String id) {
		String sql="select * from d_drugs where s_id=?";
		Object[] obj = {id};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}
//	查询某一分类下的总记录数
	@Override
	public int getCountByClassify(int classify) {
		String sql="select count(*) from d_drugs where c_id =?";
		Object[] obj= {classify};
		List<Map<String, String>> list=du.select(sql, obj);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}
//	按分类分页查找
	@Override
	public List<Drugs> selectDrugsByClassifylimit(int classify, int b, int l) {
		String sql="select * from d_drugs where c_id=? limit ?,?";
		Object[] obj = {classify,b,l};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}
//	按id查找
	@Override
	public Drugs findDrugByid(int id) {
		String sql="select * from d_drugs where d_id=?";
		Object[] obj = {id};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		if (drugs != null&drugs.size()>0) {
			return drugs.get(0);
		}
		return null;
	}
//	按商家id查记录数
	@Override
	public int getCountBySid(int sid) {
		String sql="select count(*) from d_drugs where s_id =?";
		Object[] obj= {sid};
		List<Map<String, String>> list=du.select(sql, obj);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}
//	按商家id分页查
	@Override
	public List<Drugs> selectDrugsBySidlimit(int sid, int b, int l) {
		String sql="select * from d_drugs where s_id=? limit ?,?";
		Object[] obj = {sid,b,l};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}
//	商家id分类id查记录数
	@Override
	public int getCountBySidClassify(int sid, int cid) {
		String sql="select count(*) from d_drugs where s_id =? and c_id=?";
		Object[] obj= {sid,cid};
		List<Map<String, String>> list=du.select(sql, obj);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}
//		商家id分类id分页查
	@Override
	public List<Drugs> selectDrugsByClassifySidlimit(int sid, int cid, int b, int l) {
		String sql="select * from d_drugs where s_id =? and c_id=? limit ?,?";
		Object[] obj = {sid,cid,b,l};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}
//	新增药品
	@Override
	public int addDrug(Drugs d) {
		 String sql="insert into d_drugs values(?,?,?,?,?,?,?)";
	     Object[] obj={null,d.getDname(),d.getDprice(),d.getDecpict(),d.getCid(),d.getSid(),d.getStock()};
	     int row=du.Update(sql,obj);
	     return row;
	}
//	按商家id查询记录数
	@Override
	public int getCountBySearchSid(int sid, String searchu) {
		String sql="select count(*) from d_drugs where s_id =? and d_name like '%"+searchu+"%'";
		Object[] obj= {sid};
		List<Map<String, String>> list=du.select(sql, obj);
		if (list!=null && list.size()>0) {
			return Integer.parseInt(list.get(0).get("count(*)"));
		} else {
			return 0;
		}
	}
//	按商家id分页查找
	@Override
	public List<Drugs> searchBySidLimit(int sid, String searchu, int b, int l) {
		String sql="select * from d_drugs where s_id =? and d_name like '%"+searchu+"%' limit ?,?";
		Object[] obj = {sid,b,l};
		List<Drugs> drugs=mapToDrugs(sql, obj);
		return drugs;
	}

}
