package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Score;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}