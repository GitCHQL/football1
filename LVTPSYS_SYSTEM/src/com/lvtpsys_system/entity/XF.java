package com.lvtpsys_system.entity;

import java.util.List;

public class XF {
	
	
	private float shouru;
	private float zhichu;
	private List<XF_item> xfs;
	public float getShouru() {
		return shouru;
	}
	public void setShouru(float shouru) {
		this.shouru = shouru;
	}
	public float getZhichu() {
		return zhichu;
	}
	public void setZhichu(float zhichu) {
		this.zhichu = zhichu;
	}
	
	
	public XF(float shouru, float zhichu, List<XF_item> xfs) {
		super();
		this.shouru = shouru;
		this.zhichu = zhichu;
		this.xfs = xfs;
	}
	public List<XF_item> getXfs() {
		return xfs;
	}
	public void setXfs(List<XF_item> xfs) {
		this.xfs = xfs;
	}
	public XF() {
	}
	
}
