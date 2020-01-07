package com.ssm.service;

import java.text.ParseException;
import java.util.List;

import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.SysUser;


public interface MoaCookbookService {

	List<MoaCookbook> getCookCdateList();

	MoaCookbook findDateMoaCookbook(String date);

	int updateAndInsertCookbook(MoaCookbook moaCookbook);

	MoaCookbook getIdCookbook(Integer id);

	int insertMoaCookbookAndMoaWeek(SysUser user, MoaCookbook moaCookbook, String mondayDate, String sundayDate) throws ParseException;

	List<MoaCookbook> getCookCdateListDate(Integer i);


	
}
