package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

	List<SysMenu> findBreakAndLunch(@Param("id")Integer id);

	List<SysMenu> findCaiPin(@Param("id")Integer id);
}