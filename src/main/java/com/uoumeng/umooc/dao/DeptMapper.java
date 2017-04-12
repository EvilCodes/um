package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Dept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}