package com.lvtpsys_system.entity;

import java.util.List;

public class SR {
	
	private float zsr;//总收入
	private float zfz;//总负债
	private List<SR_item> srItems;
	public float getZsr() {
		return zsr;
	}
	public void setZsr(float zsr) {
		this.zsr = zsr;
	}
	public float getZfz() {
		return zfz;
	}
	public void setZfz(float zfz) {
		this.zfz = zfz;
	}
	public List<SR_item> getSrItems() {
		return srItems;
	}
	public void setSrItems(List<SR_item> srItems) {
		this.srItems = srItems;
	}
	public SR(float zsr, float zfz, List<SR_item> srItems) {
		super();
		this.zsr = zsr;
		this.zfz = zfz;
		this.srItems = srItems;
	}
	public SR() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
