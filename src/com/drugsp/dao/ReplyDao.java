package com.drugsp.dao;

import java.util.List;

import com.drugsp.bean.Reply;

public interface ReplyDao {
//	按商家id删除留言    ps:删除商家时
	void deleteReplyBySid(int id);
//	按回复id删除留言    ps:删除用户时删除留言及回复
	void deleteReplyByMid(int mid);
//	查所有留言
	List<Reply> findAllReply();
//	新增留言
	int addReply(int sid, int sid2, String content);

}
