package com.ssm.mapper;

import com.ssm.entiy.SysMdict;

public interface SysMdictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMdict record);

    int insertSelective(SysMdict record);

    SysMdict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMdict record);

    int updateByPrimaryKey(SysMdict record);
}