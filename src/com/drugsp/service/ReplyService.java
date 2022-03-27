package com.drugsp.service;

import java.util.List;

import com.drugsp.bean.Reply;

public interface ReplyService {

	List<Reply> findAllReply();
//新增回复
	boolean addReply(int mid, int sid, String content);

}
