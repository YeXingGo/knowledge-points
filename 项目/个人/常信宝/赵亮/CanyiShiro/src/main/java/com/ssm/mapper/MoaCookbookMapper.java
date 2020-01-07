package com.ssm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.entiy.MoaCookbook;

public interface MoaCookbookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoaCookbook record);

    int insertSelective(MoaCookbook record);

    MoaCookbook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoaCookbook record);

    int updateByPrimaryKey(MoaCookbook record);

	List<MoaCookbook> getCookCdateList();

	MoaCookbook findDateMoaCookbook(@Param("date")String date);

	List<MoaCookbook> getCookCdateListDate(@Param("id")Integer i);


}