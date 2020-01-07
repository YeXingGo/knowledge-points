package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

	List<SysRole> getSysRoleAll();

	List<SysRole> getRoleAll_OfficeID(@Param("list")List<Integer> roleIdS);

	SysRole getIdRole(@Param("id")Integer roleId,@Param("officeId") Integer officeId);

	SysRole getIdRolesss(@Param("id")Integer roleId);

	
}