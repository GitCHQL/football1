package com.lvtpsys_system.entity;

public class XF_item {
	private int id;
	private int year;
	private int mother;
	private int day;
	private float money;
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	private String type;
	private String item_type;
	private String info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMother() {
		return mother;
	}
	public void setMother(int mother) {
		this.mother = mother;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String itemType) {
		item_type = itemType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public XF_item(int id, int year, int mother, int day, float money,
			String type, String itemType, String info) {
		super();
		this.id = id;
		this.year = year;
		this.mother = mother;
		this.day = day;
		this.money = money;
		this.type = type;
		item_type = itemType;
		this.info = info;
	}
	
	
	
}
