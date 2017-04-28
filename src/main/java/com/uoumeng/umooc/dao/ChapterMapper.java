package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    List<Chapter> selectAllChapters();
}