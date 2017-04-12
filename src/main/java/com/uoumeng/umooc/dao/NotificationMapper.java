package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Notification;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}