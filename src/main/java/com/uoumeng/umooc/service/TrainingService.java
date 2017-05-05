package com.uoumeng.umooc.service;

import com.uoumeng.umooc.bean.Answer;
import com.uoumeng.umooc.entity.Training;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface TrainingService {
    /**
     * 根据小节ID获取练习
     * @param seId
     * @return
     */
    Map<String,List<Training>> selectTrainingBySeId(Integer seId);

    /**
     * 根据章ID获取整章形式考试
     * @param chId
     * @return
     */
    Map<String,List<Training>> selectFormalExamByChId(Integer chId);

    /**
     * 判分
     * @param answer
     * @return
     */
    Map<String,Object> correctTraining(Answer answer);
}
