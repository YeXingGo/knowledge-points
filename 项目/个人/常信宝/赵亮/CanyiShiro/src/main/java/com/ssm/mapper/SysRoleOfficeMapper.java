package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.SysRoleOfficeKey;

public interface SysRoleOfficeMapper {
    int deleteByPrimaryKey(SysRoleOfficeKey key);

    int insert(SysRoleOfficeKey record);

    int insertSelective(SysRoleOfficeKey record);

	List<Integer> getRoleList(@Param("id")Integer id);

	SysRoleOfficeKey getRoleOfficeOffice(@Param("id") Integer officeId);
}