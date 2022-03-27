package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Order;
import com.drugsp.bean.User;
import com.drugsp.dao.DrugsDao;
import com.drugsp.dao.OrderDao;
import com.drugsp.dao.impl.DrugsDaoImpl;
import com.drugsp.dao.impl.OrderDaoImpl;
import com.drugsp.service.DrugsService;
import com.drugsp.service.OrderService;

public class DrugsServiceImpl implements DrugsService{
DrugsDao dd=new DrugsDaoImpl();
	@Override
	public int getCount() {
		int count =dd.getCount();
		return count;
	}

	@Override
	public List<Drugs> selectDrugsByLimit(int page, int l) {
		int b=(page-1)*l;
//		开始的记录数不为负数，以防sql语句异常
		if (b<0) {
			b=0;
		}
		List<Drugs> list= dd.selectDrugsBylimit(b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public boolean deleteDrugs(String id) {
		OrderDao od=new OrderDaoImpl();
//		删除药品产生的订单
		od.deleteOrderByDid(Integer.parseInt(id));
		int row=dd.deleteDrugs(Integer.parseInt(id));
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}

	@Override
	public int getCountBySearch(String searchu) {
		if (searchu==null) {
			searchu="";
		}
		int count =dd.getCountBySearch(searchu);
		return count;
	}

	@Override
	public List<Drugs> searchByLimit(String searchu, int page, int l) {
		int b=(page-1)*l;
		if (b<0) {
			b=0;
		}
		if (searchu==null) {
			searchu="";
		}
		List<Drugs> list= dd.searchByLimit(searchu,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public boolean updateDrugs(Drugs d) {
		int row=dd.updateDrugs(d);
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}

	@Override
	public List<Drugs> findAlldrugs() {
		return dd.findAllDrugs();
	}

	@Override
	public int getCountByClassify(int classify) {
		int count =dd.getCountByClassify(classify);
		return count;
	}

	@Override
	public List<Drugs> selectDrugsByClassifyLimit(int classify, int page, int l) {
		int b=(page-1)*l;
		if(b<0) {
			b=0;
		}
		List<Drugs> list= dd.selectDrugsByClassifylimit(classify,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public Drugs findDrugByid(int id) {
		return dd.findDrugByid(id);
	}

	@Override
	public boolean DrugsSell(Drugs drug, int num, int uid) {
		OrderDao od=new OrderDaoImpl();
//		修改库存
		int row1=dd.updateDrugs(drug);
//		新增订单信息
		int row2=od.addOrder(drug,num,uid);
		if (row1!=0&&row2!=0){
            return true;
        }else {		
            return false;
        }
	}

	@Override
	public int getCountBySid(int sid) {
		int count =dd.getCountBySid(sid);
		return count;
	}

	@Override
	public List<Drugs> selectDrugsBySidLimit(int sid,int page, int l) {
		int b=(page-1)*l;
		List<Drugs> list= dd.selectDrugsBySidlimit(sid,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public int getCountBySidClassify(int sid, int cid) {
		int count =dd.getCountBySidClassify(sid,cid);
		return count;
	}

	@Override
	public List<Drugs> selectDrugsByClassifySidLimit(int sid, int cid, int page, int l) {
		int b=(page-1)*l;
		if(b<0) {
			b=0;
		}
		List<Drugs> list= dd.selectDrugsByClassifySidlimit(sid,cid,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public boolean addDrug(Drugs d) {
		 int row=dd.addDrug(d);
	        if (row>0){
	        	return true;
	        }else{
	            return false;
	        }
	}

	@Override
	public int getCountBySearchSid(int sid, String searchu) {
		if (searchu==null) {
			searchu="";
		}
		int count =dd.getCountBySearchSid(sid,searchu);
		return count;
	}

	@Override
	public List<Drugs> searchBySidLimit(int sid, String searchu, int page, int l) {
		int b=(page-1)*l;
		List<Drugs> list= dd.searchBySidLimit(sid,searchu,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}


}
