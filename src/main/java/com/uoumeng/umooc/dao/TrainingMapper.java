package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Training;

import java.util.List;

public interface TrainingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Training record);

    int insertSelective(Training record);

    Training selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Training record);

    int updateByPrimaryKey(Training record);

    /**
     * 查询练习
     * @param seId
     * @return
     */
    List<Training> selectTrainingBySeId(Integer seId);

    /**
     * 查询形式考试考题
     * @param chId
     * @return
     */
    List<Training> selectFormalExamByChId(Integer chId);
}