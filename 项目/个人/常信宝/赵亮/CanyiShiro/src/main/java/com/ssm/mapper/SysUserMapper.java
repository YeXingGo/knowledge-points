package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    //自己的
    List<SysUser> getSysUserAll();

	SysUser login(@Param("user")SysUser user);
	
	
	int insertUser(@Param("user") SysUser record);

	Integer getLoginNameCount(@Param("loginName")String loginName);

	Integer getNoUser(@Param("no")String no);

	Integer getUserID(@Param("name")String name);

	SysUser findUser(@Param("loginName") String loginname);

	List<SysUser> getCompanyIdFindUser(@Param("companyId")Integer companyId);
}