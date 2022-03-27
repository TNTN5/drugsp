package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.Classify;

public interface ClassifyDao {
// 查询所有分类
	List<Classify> findAllClassify();

}
