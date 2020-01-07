package com.ssm.mapper;

import com.ssm.entiy.MoaFeedback;

public interface MoaFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoaFeedback record);

    int insertSelective(MoaFeedback record);

    MoaFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoaFeedback record);

    int updateByPrimaryKey(MoaFeedback record);
}