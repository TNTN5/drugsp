package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.Message;

public interface MessageDao {
//	按用户记录查询留言  ps:用于删除用户时同时删除留言
	List<Message> findMessageByUid(String id);
//	删除留言
	void deleteMessage(int mid);
//	查询所有留言
	List<Message> findAllMessage();
//	新增留言
	int addMessage(int uid, String content);


}
