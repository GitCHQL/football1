package com.lvtpsys_system.entity;

public class LYJD {

	private int id;
	private String l_name;
	private String jianjie;
	private String meishi;
	private String jiaotong;
	private String l_time;
	private int l_number;
	
	
	public LYJD(int id, String lName, String jianjie, String meishi,
			String jiaotong, String lTime, int lNumber) {
		super();
		this.id = id;
		l_name = lName;
		this.jianjie = jianjie;
		this.meishi = meishi;
		this.jiaotong = jiaotong;
		l_time = lTime;
		l_number = lNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String lName) {
		l_name = lName;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getMeishi() {
		return meishi;
	}
	public void setMeishi(String meishi) {
		this.meishi = meishi;
	}
	public String getJiaotong() {
		return jiaotong;
	}
	public void setJiaotong(String jiaotong) {
		this.jiaotong = jiaotong;
	}
	public String getL_time() {
		return l_time;
	}
	public void setL_time(String lTime) {
		l_time = lTime;
	}
	public int getL_number() {
		return l_number;
	}
	public void setL_number(int lNumber) {
		l_number = lNumber;
	}
	
	
}
