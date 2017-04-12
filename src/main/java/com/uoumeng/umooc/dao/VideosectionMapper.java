package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Videosection;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideosectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Videosection record);

    int insertSelective(Videosection record);

    Videosection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Videosection record);

    int updateByPrimaryKey(Videosection record);
}