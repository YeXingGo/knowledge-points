package com.ssm.mapper;

import com.ssm.entiy.MoaVoteresult;

public interface MoaVoteresultMapper {
    int deleteByPrimaryKey(String id);

    int insert(MoaVoteresult record);

    int insertSelective(MoaVoteresult record);

    MoaVoteresult selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MoaVoteresult record);

    int updateByPrimaryKey(MoaVoteresult record);
}