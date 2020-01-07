package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.SysOffice;
import com.ssm.entiy.SysRole;

public interface SysOfficeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOffice record);

    int insertSelective(SysOffice record);

    SysOffice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOffice record);

    int updateByPrimaryKey(SysOffice record);

	List<SysOffice> getGongSiOffice();
	
	
	List<SysOffice> getBumenOffice(@Param("roles")SysRole sysRoles);

	String getOfficeName(@Param("id")Integer id);
}