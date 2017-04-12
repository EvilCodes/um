package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Workorder;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workorder record);

    int insertSelective(Workorder record);

    Workorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workorder record);

    int updateByPrimaryKey(Workorder record);
}