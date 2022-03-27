package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Shops;
import com.drugsp.bean.User;
import com.drugsp.dao.DrugsDao;
import com.drugsp.dao.OrderDao;
import com.drugsp.dao.ReplyDao;
import com.drugsp.dao.ShopsDao;
import com.drugsp.dao.impl.DrugsDaoImpl;
import com.drugsp.dao.impl.OrderDaoImpl;
import com.drugsp.dao.impl.ReplyDaoImpl;
import com.drugsp.dao.impl.ShopsDaoImpl;
import com.drugsp.service.ShopsService;

public class ShopsServiceImpl implements ShopsService{
	ShopsDao sd=new ShopsDaoImpl();
	@Override
	public Shops getLogin(String loginname, String password) {
		return sd.getLogin(loginname, password);
	}
	@Override
	public int getCount() {
		int count =sd.getCount();
		return count;
	}
	@Override
	public List<Shops> selectShopsByLimit(int page, int l) {
		int b=(page-1)*l;
		if (b<0) {
			b=0;
		}
		List<Shops> list= sd.selectShopsBylimit(b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
	public int getCountBySearch(String searchu) {
//		如果搜索框内容为空，赋值为空字符串
		if (searchu==null) {
			searchu="";
		}
		int count =sd.getCountBySearch(searchu);
		return count;
	}
	@Override
	public List<Shops> searchByLimit(String searchu, int page, int l) {
		int b=(page-1)*l;
		if (b<0) {
			b=0;
		}
//		搜索框内容为空时，赋值空字符，查所有
		if (searchu==null) {
			searchu="";
		}
		List<Shops> list= sd.searchByLimit(searchu,b, l);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	@Override
//	删除商家
	public boolean deleteShops(String id) {
		DrugsDao dd=new DrugsDaoImpl();
		OrderDao od=new OrderDaoImpl();
		ReplyDao rd=new ReplyDaoImpl();
//		删除商家发的回复
		rd.deleteReplyBySid(Integer.parseInt(id));
//		查询商家发布的商品
		List<Drugs> drugs=dd.findDrugsBySid(id);
		for (Drugs d : drugs) {
//			删除药品
			dd.deleteDrugs(d.getDrugid());
//			删除商家药品的订单
			od.deleteOrderByDid(d.getDrugid());
		}
		int row=sd.deleteShops(Integer.parseInt(id));
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}
	@Override
	public boolean updateShops(Shops s) {
		int row=sd.updateShops(s);
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}
	@Override
	public boolean addShops(Shops s) {
		int row=sd.AddShops(s);
        if (row!=0){
            return true;
        }else {		
            return false;
        }
	}
	@Override
	public List<Shops> findAllShops() {
		return sd.findAllShops();
	}

}
