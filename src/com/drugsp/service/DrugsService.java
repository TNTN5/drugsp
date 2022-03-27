package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.Drugs;

public interface DrugsService {
//获取药品记录总数
	int getCount();
//分页查询
	List<Drugs> selectDrugsByLimit(int page, int l);
//删除药品
	boolean deleteDrugs(String parameter);
//获取模糊查询记录数
	int getCountBySearch(String searchu);
//模糊查询分页查询药品
	List<Drugs> searchByLimit(String searchu, int page, int l);
//修改药品
	boolean updateDrugs(Drugs d);
//查所有药品
	List<Drugs> findAlldrugs();
//按分类查询记录数
	int getCountByClassify(int classify);
//按分类分页查询药品
	List<Drugs> selectDrugsByClassifyLimit(int classify, int page, int l);
//按id查药品
	Drugs findDrugByid(int id);
//用户点击购买，药品出售
	boolean DrugsSell(Drugs drug, int num, int uid);
//按商家id获取记录数
	int getCountBySid(int sid);
//按商家id分页查询
	List<Drugs> selectDrugsBySidLimit(int sid,int page, int l);
//按商家id分类获取记录数
	int getCountBySidClassify(int sid, int cid);
//按商家id分类分页查
	List<Drugs> selectDrugsByClassifySidLimit(int sid, int cid, int page, int l);
//添加药品
	boolean addDrug(Drugs d);
//按商家id模糊查询记录数
	int getCountBySearchSid(int sid, String searchu);
//按商家id模糊查询分页查询
	List<Drugs> searchBySidLimit(int sid, String searchu, int page, int l);

}
