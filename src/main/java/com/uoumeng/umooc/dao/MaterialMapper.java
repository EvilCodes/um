package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Material;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}