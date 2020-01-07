package com.ssm.service.Imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.entiy.SysMenu;
import com.ssm.mapper.SysMenuMapper;
import com.ssm.service.SysMenuService;

@Transactional
@Service
public class SysMenuServiceImp implements SysMenuService {
	@Resource
	private SysMenuMapper menuMapper;

	@Override
	public List<SysMenu> findBreakAndLunch(Integer id) {
		return menuMapper.findBreakAndLunch(id);
	}

	@Override
	public List<SysMenu> findCaiPin(Integer id) {
		return menuMapper.findCaiPin(id);
	}
	
	

}
