package com.ssm.service;

import java.util.List;

import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysOffice;
import com.ssm.entiy.SysRole;

public interface SysOfficeService {

	List<SysOffice> getGongSiOffice();

	List<SysOffice> getBumen(SysRole sysRoles);

	void getCompanyAndOfficeUser(UserOfficeUtil userOfficeUtil);
	
}
