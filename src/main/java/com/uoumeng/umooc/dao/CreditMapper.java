package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Credit;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Credit record);

    int insertSelective(Credit record);

    Credit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Credit record);

    int updateByPrimaryKey(Credit record);
}