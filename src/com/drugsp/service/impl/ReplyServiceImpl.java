package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Reply;
import com.drugsp.dao.ReplyDao;
import com.drugsp.dao.impl.ReplyDaoImpl;
import com.drugsp.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
ReplyDao rd=new ReplyDaoImpl();
	@Override
	public List<Reply> findAllReply() {
		return rd.findAllReply();
	}
	@Override
	public boolean addReply(int mid,int sid, String content) {
		int row=rd.addReply(mid,sid,content);
        if (row>0){
        	return true;
        }else{
            return false;
        }
	}

}
