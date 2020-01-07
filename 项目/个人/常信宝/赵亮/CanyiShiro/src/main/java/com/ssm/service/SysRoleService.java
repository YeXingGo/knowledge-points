package com.ssm.service;

import java.util.List;

import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysRole;

public interface SysRoleService {

	SysRole getRole(Integer i);

	List<SysRole> getAllSysUser();

	List<SysRole> getRoleAll_OfficeID(List<Integer> roleIdS);

	void getOfficeIdRole(UserOfficeUtil userOfficeUtil);
	
}
