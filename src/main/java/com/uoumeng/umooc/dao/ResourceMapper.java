package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Resource;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}