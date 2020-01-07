package com.ssm.service.Imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.BeanUtils.SouMoaWeek;
import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaWeek;
import com.ssm.entiy.SysMenu;
import com.ssm.mapper.MoaCookbookMapper;
import com.ssm.mapper.MoaWeekMapper;
import com.ssm.mapper.SysMenuMapper;
import com.ssm.service.MoaCookbookService;
import com.ssm.service.MoaWeekService;
import com.ssm.service.SysMenuService;

@Transactional
@Service
public class MoaWeekServiceImp implements MoaWeekService {
	@Resource
	private MoaWeekMapper moaWeekMapper;

	@Override
	public MoaWeek findWeekDate(String date) {
		return moaWeekMapper.findWeekDate(date);
	}

	@Override
	public List<MoaWeek> getAllMoaWeek() {
		return moaWeekMapper.getAllMoaWeek();
	}

	@Override
	public List<MoaWeek> LikeMoaWeek(SouMoaWeek souMoaWeek) {
		
		return moaWeekMapper.LikeMoaWeek(souMoaWeek);
	}

	

}
