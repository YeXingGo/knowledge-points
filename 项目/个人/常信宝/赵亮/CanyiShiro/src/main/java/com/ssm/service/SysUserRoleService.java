package com.ssm.service;

import java.util.List;

import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;
import com.ssm.entiy.SysUserRoleKey;

public interface SysUserRoleService {

	List<SysUserRoleKey> getUserRoleKey(SysUser user);

	int insertUserRole(SysUserRoleKey userRole);

	void getUserIdList(UserOfficeUtil userOfficeUtil);

	SysRole getRole(SysUser user1);

}
