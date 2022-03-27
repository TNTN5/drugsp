package com.drugsp.bean;
/*
 * 用户留言实体类
 * */
public class Message {
	private int mid;			//留言序号
	private int uid;			//用户id
	private String mcontent;	//内容
	private String mtime;		//留言时间
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	
}
