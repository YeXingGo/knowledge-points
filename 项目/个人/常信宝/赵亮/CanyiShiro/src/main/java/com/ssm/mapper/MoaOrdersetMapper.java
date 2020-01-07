package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.MoaOrderset;

public interface MoaOrdersetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoaOrderset record);

    int insertSelective(MoaOrderset record);

    MoaOrderset selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoaOrderset record);

    int updateByPrimaryKey(MoaOrderset record);

	List<MoaOrderset> getListOrderset(@Param("id")Integer id);
}