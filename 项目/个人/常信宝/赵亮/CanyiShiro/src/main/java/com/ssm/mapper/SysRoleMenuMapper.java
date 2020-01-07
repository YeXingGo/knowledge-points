package com.ssm.mapper;

import com.ssm.entiy.SysRoleMenuKey;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenuKey key);

    int insert(SysRoleMenuKey record);

    int insertSelective(SysRoleMenuKey record);
}