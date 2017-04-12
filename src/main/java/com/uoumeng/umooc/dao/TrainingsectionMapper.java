package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Trainingsection;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrainingsectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trainingsection record);

    int insertSelective(Trainingsection record);

    Trainingsection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trainingsection record);

    int updateByPrimaryKey(Trainingsection record);
}