package com.ssm.service.Imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.SysRoleOfficeMapper;
import com.ssm.service.SysRoleOfficeService;
@Transactional
@Service
public class SysRoleOfficeServiceImp implements SysRoleOfficeService {
	@Resource
	private SysRoleOfficeMapper roleOfficeMapper;
	@Override
	public List<Integer> getRoleList(Integer id) {
		
		return roleOfficeMapper.getRoleList(id);
	}

}
