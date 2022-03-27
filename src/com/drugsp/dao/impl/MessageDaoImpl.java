package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Drugs;
import com.drugsp.bean.Message;
import com.drugsp.dao.MessageDao;
import com.drugsp.util.DB_util;

public class MessageDaoImpl implements MessageDao{
DB_util du =new DB_util();
private List<Message> mapToMessage(String sql,Object[] obj){
	List<Message> ms=new ArrayList<>();
	List<Map<String,String>> maps=du.select(sql, obj);
	for (Map<String, String> m : maps) {
		Message me=new Message();
		me.setMid(Integer.parseInt(m.get("m_id")));
		me.setMcontent(m.get("m_content"));
		me.setUid(Integer.parseInt(m.get("u_id")));
		me.setMtime(m.get("m_time"));
		ms.add(me);
	}
	return ms;
}


@Override
public List<Message> findMessageByUid(String id) {
	String sql="select * from d_message where u_id=?";
	Object[] obj = {id};
	List<Message> ms=mapToMessage(sql, obj);
	return ms;
}

@Override
public void deleteMessage(int mid) {
	String sql="delete from d_message where m_id=?";
    Object[] obj={mid};
    int row=du.Update(sql,obj);
}


@Override
public List<Message> findAllMessage() {
	String sql="select * from d_message order by m_time desc";
	List<Message> ms= mapToMessage(sql, null);
	return ms;
}


@Override
public int addMessage(int uid, String content) {
	String sql="insert into d_message values(?,?,?,now())";
    Object[] obj={null,uid,content};
    int row=du.Update(sql,obj);
    return row;
}
	
}
