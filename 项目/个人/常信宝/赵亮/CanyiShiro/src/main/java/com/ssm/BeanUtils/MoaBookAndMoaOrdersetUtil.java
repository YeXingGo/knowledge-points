package com.ssm.BeanUtils;

import java.util.List;

import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaOrderset;

public class MoaBookAndMoaOrdersetUtil {
	private MoaCookbook moaCookBook;
	private List<MoaOrderset> list;
	public MoaCookbook getMoaCookBook() {
		return moaCookBook;
	}
	public void setMoaCookBook(MoaCookbook moaCookBook) {
		this.moaCookBook = moaCookBook;
	}
	public List<MoaOrderset> getList() {
		return list;
	}
	public void setList(List<MoaOrderset> list) {
		this.list = list;
	}
	
}
