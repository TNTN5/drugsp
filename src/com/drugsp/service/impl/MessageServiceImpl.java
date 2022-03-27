package com.drugsp.service.impl;

import java.util.List;

import com.drugsp.bean.Message;
import com.drugsp.dao.MessageDao;
import com.drugsp.dao.impl.MessageDaoImpl;
import com.drugsp.service.MessageService;

public class MessageServiceImpl implements MessageService{
MessageDao md=new MessageDaoImpl();
	@Override
	public List<Message> findAllMessage() {
		return md.findAllMessage();
	}
	@Override
	public boolean addMessage(int uid, String content) {
		int row=md.addMessage(uid,content);
        if (row>0){
        	return true;
        }else{
            return false;
        }
	}

}
