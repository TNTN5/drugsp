package com.drugsp.bean;
/*
 * 订单类
 * */
public class Order {
	private int oid;
	private int drugid;		//订单商品的id
	private int dnum;		//购买商品的数目
	private int sid;		//卖家
	private int uid;		//买家
	private String ocreatetime;	//创建时间
	private String ofinishtime;	//完成时间
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOcreatetime() {
		return ocreatetime;
	}
	public void setOcreatetime(String ocreatetime) {
		this.ocreatetime = ocreatetime;
	}
	public String getOfinishtime() {
		return ofinishtime;
	}
	public void setO_finishtime(String ofinishtime) {
		this.ofinishtime = ofinishtime;
	}
	public int getDrugid() {
		return drugid;
	}
	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	
}
