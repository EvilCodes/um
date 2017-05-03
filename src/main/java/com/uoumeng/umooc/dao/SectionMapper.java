package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Section;

/**
 * Created by chenjun on 2017/5/3.
 */
public interface SectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}
