package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Qanda;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QandaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qanda record);

    int insertSelective(Qanda record);

    Qanda selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qanda record);

    int updateByPrimaryKey(Qanda record);
}