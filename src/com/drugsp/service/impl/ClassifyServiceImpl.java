package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Classify;
import com.drugsp.dao.ClassifyDao;
import com.drugsp.dao.impl.ClassifyDaoImpl;
import com.drugsp.service.ClassifyService;

public class ClassifyServiceImpl implements ClassifyService{
ClassifyDao cd=new ClassifyDaoImpl();
	@Override
	public List<Classify> findAllClassify() {
		return cd.findAllClassify();
	}

}
