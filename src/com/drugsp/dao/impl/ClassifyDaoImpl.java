package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Classify;
import com.drugsp.bean.Shops;
import com.drugsp.dao.ClassifyDao;
import com.drugsp.util.DB_util;

public class ClassifyDaoImpl implements ClassifyDao{
DB_util du=new DB_util();
//	将获取到的List<Map>转换成List<Classify>
	private List<Classify> mapToClassify(String sql,Object[] obj){
		List<Classify> classifys=new ArrayList<>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			Classify c=new Classify();
			c.setCid(Integer.parseInt(m.get("c_id")));
			c.setCname(m.get("c_name"));
			classifys.add(c);
		}
		return classifys;
	}
//获取所有分类信息
	@Override
	public List<Classify> findAllClassify() {
		String sql ="select * from d_classify";
		List<Classify> cs=mapToClassify(sql, null);
		return cs;
	}

}
