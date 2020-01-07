package com.ssm.BeanUtils;

public class SouMoaWeek {
	private Integer id;
	private String date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "SouMoaWeek [id=" + id + ", date=" + date + "]";
	}
	
}
