package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Notistu;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotistuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notistu record);

    int insertSelective(Notistu record);

    Notistu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notistu record);

    int updateByPrimaryKey(Notistu record);
}