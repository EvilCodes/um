package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Video;

/**
 * Created by chenjun on 2017/5/3.
 */
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}
