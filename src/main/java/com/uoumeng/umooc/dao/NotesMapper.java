package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Notes;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notes record);

    int insertSelective(Notes record);

    Notes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notes record);

    int updateByPrimaryKey(Notes record);
}