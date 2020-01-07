package com.ssm.service.Imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysOffice;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;
import com.ssm.mapper.SysOfficeMapper;
import com.ssm.mapper.SysRoleMapper;
import com.ssm.mapper.SysUserMapper;
import com.ssm.service.SysOfficeService;
import com.ssm.service.SysRoleService;
import com.ssm.service.SysUserService;
@Transactional
@Service
public class SysOfficeServiceImp implements SysOfficeService {
	@Resource
	private SysOfficeMapper officeMapper;

	@Override
	public List<SysOffice> getGongSiOffice() {
		return officeMapper.getGongSiOffice();
	}

	@Override
	public List<SysOffice> getBumen(SysRole sysRoles) {
		// TODO Auto-generated method stub
		return officeMapper.getBumenOffice(sysRoles);
	}

	@Override
	public void getCompanyAndOfficeUser(UserOfficeUtil userOfficeUtil) {
		if(userOfficeUtil.getUser().getCompanyId()!=null){
			
			String companyName = officeMapper.getOfficeName(userOfficeUtil.getUser().getCompanyId());
			 userOfficeUtil.setComptyName(companyName);
		}
		if(userOfficeUtil.getUser().getOfficeId()!=null){
			String officeName = officeMapper.getOfficeName(userOfficeUtil.getUser().getOfficeId());
			userOfficeUtil.setOfficeName(officeName);
		
		}
		//通过用户的公司编号查找到 公司名称
		
	}
	
	

}
