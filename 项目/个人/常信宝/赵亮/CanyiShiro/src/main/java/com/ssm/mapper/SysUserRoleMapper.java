package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.SysUser;
import com.ssm.entiy.SysUserRoleKey;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);
   
    List<SysUserRoleKey>  selectSysUserRole(@Param("user")SysUser user);

}