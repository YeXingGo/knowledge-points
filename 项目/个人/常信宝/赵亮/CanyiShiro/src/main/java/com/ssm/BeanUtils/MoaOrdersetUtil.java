package com.ssm.BeanUtils;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ssm.entiy.MoaOrderset;

public class MoaOrdersetUtil {
	private MoaOrderset moaOrderset;
	private MoaOrderset moaOrderset1;
	private MoaOrderset moaOrderset2;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date cdate;
	private String week;
	
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public MoaOrderset getMoaOrderset() {
		return moaOrderset;
	}
	public void setMoaOrderset(MoaOrderset moaOrderset) {
		this.moaOrderset = moaOrderset;
	}
	public MoaOrderset getMoaOrderset1() {
		return moaOrderset1;
	}
	public void setMoaOrderset1(MoaOrderset moaOrderset1) {
		this.moaOrderset1 = moaOrderset1;
	}
	public MoaOrderset getMoaOrderset2() {
		return moaOrderset2;
	}
	public void setMoaOrderset2(MoaOrderset moaOrderset2) {
		this.moaOrderset2 = moaOrderset2;
	}
	

	
}
