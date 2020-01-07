package com.ssm.service;

import java.util.List;

import com.ssm.entiy.SysUser;

public interface SysUserService {
	
    public List<SysUser> getAllSysUser();

	public SysUser login(SysUser user);


	public int ZhuCe(SysUser user,SysUser CreatUser);

	public int getUserID(String name);

	public SysUser findUser(String loginname);

	public List<SysUser> getCompanyIdFindUser(Integer companyId);

}
