package com.ssm.service;

import java.util.List;

import com.ssm.BeanUtils.SouMoaWeek;
import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaWeek;


public interface MoaWeekService {

	MoaWeek findWeekDate(String date);

	List<MoaWeek> getAllMoaWeek();

	List<MoaWeek> LikeMoaWeek(SouMoaWeek souMoaWeek);



	
}
