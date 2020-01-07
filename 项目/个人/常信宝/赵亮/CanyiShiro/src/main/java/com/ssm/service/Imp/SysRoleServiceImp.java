package com.ssm.service.Imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysRoleOfficeKey;
import com.ssm.entiy.SysUser;
import com.ssm.mapper.SysRoleMapper;
import com.ssm.mapper.SysRoleOfficeMapper;
import com.ssm.mapper.SysUserMapper;
import com.ssm.service.SysRoleService;
import com.ssm.service.SysUserService;
@Transactional
@Service
public class SysRoleServiceImp implements SysRoleService {
	@Resource
	private SysRoleMapper roleMapper;
	@Resource
	private SysRoleOfficeMapper roleOfficeMapper;
	@Override
	public SysRole getRole(Integer id) {
		
		return roleMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<SysRole> getAllSysUser() {
		// TODO Auto-generated method stub
		return roleMapper.getSysRoleAll();
	}


	@Override
	public List<SysRole> getRoleAll_OfficeID(List<Integer> roleIdS) {
			
			return roleMapper.getRoleAll_OfficeID(roleIdS);
	}


	@Override
	public void getOfficeIdRole(UserOfficeUtil userOfficeUtil) {
		//用户是否有部门
		if(userOfficeUtil.getUser().getOfficeId()!=null){
			//查询用户角色表
			SysRoleOfficeKey roleOffice=roleOfficeMapper.getRoleOfficeOffice(userOfficeUtil.getUser().getOfficeId());
		}else{
			if(userOfficeUtil.getUser().getCompanyId()!=null){
				
			}
		}
		
	}

}
