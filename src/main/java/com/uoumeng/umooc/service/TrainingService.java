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
     * 小节练习判分
     * @param answer
     * @param sid
     * @return
     */
    Map<String,Integer> correctTraining(Answer answer,int sid);

    /**
     * 章形式考试判分
     * @param answer
     * @param sid
     * @return
     */
    Map<String,Object> correctFormalExam(Answer answer, int sid);
}
