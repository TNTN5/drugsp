package com.drugsp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drugsp.bean.Message;
import com.drugsp.bean.Reply;
import com.drugsp.dao.ReplyDao;
import com.drugsp.util.DB_util;

public class ReplyDaoImpl implements ReplyDao{
DB_util du=new DB_util();
	private List<Reply> mapToReply(String sql,Object[] obj){
		List<Reply> rs=new ArrayList<>();
		List<Map<String,String>> maps=du.select(sql, obj);
		for (Map<String, String> m : maps) {
			Reply r=new Reply();
			r.setRid(Integer.parseInt(m.get("r_id")));
			r.setRcontent(m.get("r_content"));
			r.setMid(Integer.parseInt(m.get("m_id")));
			r.setRtime(m.get("r_time"));
			r.setSid(Integer.parseInt(m.get("s_id")));
			rs.add(r);
		}
		return rs;
	}
//	根据商家id删除全部回复
	@Override
	public void deleteReplyBySid(int id) {
		String sql="delete from d_reply where s_id=?";
        Object[] obj={id};
        int row=du.Update(sql,obj);
	}
//	根据回复id删除全部回复
	@Override
	public void deleteReplyByMid(int mid) {
		String sql="delete from d_reply where m_id=?";
        Object[] obj={mid};
        int row=du.Update(sql,obj);
	}
//	查看全部回复
	@Override
	public List<Reply> findAllReply() {
		String sql ="select * from d_reply";
		return mapToReply(sql, null);
	}
//	新增回复
	@Override
	public int addReply(int mid,int sid, String content) {
		String sql="insert into d_reply values(?,?,?,?,now())";
	    Object[] obj={null,sid,mid,content};
	    int row=du.Update(sql,obj);
	    return row;
	}

}
