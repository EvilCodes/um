package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Addition;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdditionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Addition record);

    int insertSelective(Addition record);

    Addition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Addition record);

    int updateByPrimaryKey(Addition record);
}