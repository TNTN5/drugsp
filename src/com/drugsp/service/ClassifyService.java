package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.Classify;

public interface ClassifyService {
//获取所有分类
	List<Classify> findAllClassify();

}
