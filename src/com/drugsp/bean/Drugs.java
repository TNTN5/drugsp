package com.drugsp.bean;
/*
 * 药品实体类
 * */
public class Drugs {
	private int drugid;
	private String dname;
	private Double dprice;			//价格
	private String decpict;			//描述
	private int cid;			//分类id
	private int sid;			//所属商家id
	private int stock;	//库存数量
	
	
	
	public int getDrugid() {
		return drugid;
	}
	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public String getDecpict() {
		return decpict;
	}
	public void setDecpict(String decpict) {
		this.decpict = decpict;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
