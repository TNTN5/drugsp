package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.Drugs;

public interface DrugsDao {
//	获取记录数
	int getCount();
//	分页查询
	List<Drugs> selectDrugsBylimit(int b, int l);
//	删除药品
	int deleteDrugs(int parseInt);
//	模糊查询药品记录数
	int getCountBySearch(String searchu);
//	模糊查询分页
	List<Drugs> searchByLimit(String searchu, int b, int l);
//	修改药品
	int updateDrugs(Drugs d);
//	查询所有药品
	List<Drugs> findAllDrugs();
//	根据商家id查询所有药品
	List<Drugs> findDrugsBySid(String id);
//	按药品分类获取记录数
	int getCountByClassify(int classify);
//	商品分类分页查询
	List<Drugs> selectDrugsByClassifylimit(int classify, int b, int l);
//	按id查询药品
	Drugs findDrugByid(int id);
//	根据商家id查询药品记录数
	int getCountBySid(int sid);
//	按商家id分页查
	List<Drugs> selectDrugsBySidlimit(int sid, int b, int l);
//	商家id分类下的记录数
	int getCountBySidClassify(int sid, int cid);
//	商家id分类分页查
	List<Drugs> selectDrugsByClassifySidlimit(int sid, int cid, int b, int l);
//	添加药品
	int addDrug(Drugs d);
//	商家id下模糊查询记录数
	int getCountBySearchSid(int sid, String searchu);
//	商家id下模糊分页查询
	List<Drugs> searchBySidLimit(int sid, String searchu, int b, int l);

}
