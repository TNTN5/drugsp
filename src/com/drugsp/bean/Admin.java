package com.drugsp.bean;
/*
 * 管理员实体类
 * */
public class Admin {
	private int aid;				//管理员id
	private String aname;			//管理员用户名
	private String apassword;		//密码
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
}
