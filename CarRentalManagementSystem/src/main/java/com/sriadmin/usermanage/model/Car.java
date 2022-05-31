package com.sriadmin.usermanage.model;

public class Car {
	private int carid;
	private String carname;
	private String cartype;
	private String avail_from;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getAvail_from() {
		return avail_from;
	}
	public void setAvail_from(String avail_from) {
		this.avail_from = avail_from;
	}
	
	
}
