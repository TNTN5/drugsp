package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.Message;

public interface MessageService {
//获取所有留言
	List<Message> findAllMessage();
//新增留言
	boolean addMessage(int uid, String content);

}
