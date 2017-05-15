package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

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

    List<HashMap> selectSectionsByChId(@Param("chId") Integer chId, @Param("stuId") Integer stuId);
}
