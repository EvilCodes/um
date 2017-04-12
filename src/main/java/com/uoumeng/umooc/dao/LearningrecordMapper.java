package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Learningrecord;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningrecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Learningrecord record);

    int insertSelective(Learningrecord record);

    Learningrecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Learningrecord record);

    int updateByPrimaryKey(Learningrecord record);
}