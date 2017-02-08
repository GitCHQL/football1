package com.lvtpsys_system.entity;

public class SR_item {
	private int id;//id
	private String name;//总类
	private float money;//金额
	private String type;//收入还是负债
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SR_item(int id, String name, float money, String type) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.type = type;
	}
	
	
	
}
