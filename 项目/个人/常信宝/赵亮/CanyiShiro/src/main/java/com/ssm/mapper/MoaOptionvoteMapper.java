package com.ssm.mapper;

import com.ssm.entiy.MoaOptionvote;

public interface MoaOptionvoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoaOptionvote record);

    int insertSelective(MoaOptionvote record);

    MoaOptionvote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoaOptionvote record);

    int updateByPrimaryKey(MoaOptionvote record);
}