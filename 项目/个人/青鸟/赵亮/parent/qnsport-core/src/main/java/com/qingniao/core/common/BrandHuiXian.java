package com.qingniao.core.common;

import java.util.List;

import com.qingniao.core.pojo.Brand;

public class BrandHuiXian {
	private List<Brand> boandList;
	private String name;
	private Integer status;
	@Override
	public String toString() {
		return "BrandHuiXian [boandList=" + boandList + ", name=" + name + ", status=" + status + "]";
	}
	public List<Brand> getBoandList() {
		return boandList;
	}
	public void setBoandList(List<Brand> boandList) {
		this.boandList = boandList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
