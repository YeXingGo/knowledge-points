package com.ssm.mapper;

import com.ssm.entiy.MoaActivityvote;

public interface MoaActivityvoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoaActivityvote record);

    int insertSelective(MoaActivityvote record);

    MoaActivityvote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoaActivityvote record);

    int updateByPrimaryKey(MoaActivityvote record);
}