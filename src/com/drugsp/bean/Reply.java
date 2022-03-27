package com.drugsp.bean;
/*
 * 回复类
 * */
public class Reply {
	private int rid;	//回复id
	private int sid;	//卖家
	private int mid;	//回复对应的留言id
	private String rcontent;	//内容
	private String rtime;	//回复时间
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	
}
