package com.ssm.service.Imp;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;
import com.ssm.entiy.SysUserRoleKey;
import com.ssm.mapper.SysRoleMapper;
import com.ssm.mapper.SysUserRoleMapper;
import com.ssm.service.SysUserRoleService;

@Transactional
@Service
public class SysUserRoleServiceImp implements SysUserRoleService {
	@Resource
	private SysUserRoleMapper userRoleMapper;
	@Resource
	private SysRoleMapper roleMapper;

	@Override
	public List<SysUserRoleKey> getUserRoleKey(SysUser user) {
		return userRoleMapper.selectSysUserRole(user);
	}

	@Override
	public int insertUserRole(SysUserRoleKey userRole) {
		return userRoleMapper.insert(userRole);
	}

	@Override
	public void getUserIdList(UserOfficeUtil userOfficeUtil) {
		Integer uid = userOfficeUtil.getUser().getId();
		SysUser user = userOfficeUtil.getUser();
		List<SysUserRoleKey> list=userRoleMapper.selectSysUserRole(user);
		for (SysUserRoleKey sysUserRoleKey : list) {
			SysRole role=null;
			//拿到所有 用户和角色的id
			if(user.getOfficeId()!=null){
				role=roleMapper.getIdRole(sysUserRoleKey.getRoleId(),user.getOfficeId());

			}else{
				if(user.getCompanyId()!=null){
					role=roleMapper.getIdRole(sysUserRoleKey.getRoleId(),user.getCompanyId());
				}
			}
			userOfficeUtil.setRole(role);
		}
	}

	@Override
	public SysRole getRole(SysUser user) {
		SysRole role=null;
		List<SysUserRoleKey> list=userRoleMapper.selectSysUserRole(user);
		for (SysUserRoleKey sysUserRoleKey : list) {
			//拿到所有 用户和角色的id
			if(user.getOfficeId()!=null){
				role=roleMapper.getIdRole(sysUserRoleKey.getRoleId(),user.getOfficeId());

			}else{
				if(user.getCompanyId()!=null){
					role=roleMapper.getIdRole(sysUserRoleKey.getRoleId(),user.getCompanyId());
				}else{
					role=roleMapper.getIdRolesss(sysUserRoleKey.getRoleId());
				}
			}
		}
		return role;

	}


}
