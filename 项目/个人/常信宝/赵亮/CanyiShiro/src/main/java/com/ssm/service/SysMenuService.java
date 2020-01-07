package com.ssm.service;

import java.util.List;

import com.ssm.entiy.SysMenu;


public interface SysMenuService {

	List<SysMenu> findBreakAndLunch(Integer i);

	List<SysMenu> findCaiPin(Integer i);

	
}
