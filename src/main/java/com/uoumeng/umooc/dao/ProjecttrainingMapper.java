package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Projecttraining;

/**
 * Created by chenjun on 2017/5/3.
 */
public interface ProjecttrainingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Projecttraining record);

    int insertSelective(Projecttraining record);

    Projecttraining selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Projecttraining record);

    int updateByPrimaryKey(Projecttraining record);

    Projecttraining selectProjecttrainingByChId(Integer chId);
}
