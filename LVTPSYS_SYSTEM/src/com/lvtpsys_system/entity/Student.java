package com.lvtpsys_system.entity;

public class Student {

	@Override
	public String toString() {
		return "Student [age=" + age + ", banji=" + banji + ", dianhua="
				+ dianhua + ", id=" + id + ", name=" + name + ", psd=" + psd
				+ ", sex=" + sex + ", xuehao=" + xuehao + ", xueyuan="
				+ xueyuan + "]";
	}
	private int id;
	private int xuehao;
	private String name;
	private String psd;
	private String sex;
	private int age;
	private String xueyuan;
	private String banji;
	private String dianhua;
	
	public Student(){
		
	}
	
	public Student(int id, int xuehao, String name, String psd, String sex,
			int age, String xueyuan, String banji, String dianhua) {
		super();
		this.id = id;
		this.xuehao = xuehao;
		this.name = name;
		this.psd = psd;
		this.sex = sex;
		this.age = age;
		this.xueyuan = xueyuan;
		this.banji = banji;
		this.dianhua = dianhua;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getXuehao() {
		return xuehao;
	}
	public void setXuehao(int xuehao) {
		this.xuehao = xuehao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getXueyuan() {
		return xueyuan;
	}
	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}
	public String getBanji() {
		return banji;
	}
	public void setBanji(String banji) {
		this.banji = banji;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	
}
