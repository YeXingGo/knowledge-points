package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.BeanUtils.SouMoaWeek;
import com.ssm.entiy.MoaWeek;

public interface MoaWeekMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoaWeek record);

    int insertSelective(MoaWeek record);

    MoaWeek selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoaWeek record);

    int updateByPrimaryKey(MoaWeek record);

	MoaWeek findWeekDate(@Param("date")String date);

	List<MoaWeek> getAllMoaWeek();

	List<MoaWeek> LikeMoaWeek(@Param("souMoaWeek")SouMoaWeek souMoaWeek);

	MoaWeek getWeekMapper(@Param("data")String mondayDate);
}