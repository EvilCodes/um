package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.constant.Constant;
import com.uoumeng.umooc.dao.TrainingMapper;
import com.uoumeng.umooc.entity.Training;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.TrainingsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by chenjun on 2017/4/26.
 */
@Service
public class TrainingsectionServiceImpl implements TrainingsectionService{

    @Autowired
    private TrainingMapper trainingMapper;

    @Override
    public Map<String, List<Training>> selectTrainingBySeId(Integer seId) {
        try{
            List<Training> list = trainingMapper.selectTrainingBySeId(seId);
            Map<String,List<Training>> map = randomTraining(list);
            return map;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    /**
     * 将从数据库中取出的所有题目
     * 随机得到指定数量的单选题、多选题和判断题
     * @param list
     * @return
     */
    private Map<String,List<Training>> randomTraining(List<Training> list){
        // 定义List，用于存储分拣的题目信息
        List<Training> listSingleTraining = new ArrayList<>();
        List<Training> listCheckboxTraining = new ArrayList<>();
        List<Training> listJudgeTraining = new ArrayList<>();
        // 完成题目的分拣，方便随机
        for (Training training : list) {
            // 单选
            if(Constant.QUESTION_TYPE_SINGLR.equals(training.getType())){
                listSingleTraining.add(training);
             // 多选
            }else if(Constant.QUESTION_TYPE_CHECKBOX.equals(training.getType())){
                listCheckboxTraining.add(training);
             // 判断
            }else if(Constant.QUESTION_TYPE_JUDGE.equals(training.getType())){
                listJudgeTraining.add(training);
            }
        }
        // 随机题目,并存储
        List<Training> listSingle = new ArrayList<>();
        List<Training> listCheckbox = new ArrayList<>();
        List<Training> listJudeg = new ArrayList<>();
        Random ran = new Random();
        // 随机2道单选题并存储
        for(int i=0;i<Constant.NUMBER_SINGLE_TRAINSECTION;i++){
            int ranIndex = ran.nextInt(listSingleTraining.size());
            listSingle.add(listSingleTraining.get(ranIndex));
        }
        // 随机1道多选题并存储
        for(int i=0;i<Constant.NUMBER_CHECKBOX_TRAINSECTION;i++){
            int ranIndex = ran.nextInt(listCheckboxTraining.size());
            listCheckbox.add(listCheckboxTraining.get(ranIndex));
        }
        // 随机1道判断题并存储
        for(int i=0;i<Constant.NUMBER_JUDGE_TRAINSECTION;i++){
            int ranIndex = ran.nextInt(listJudgeTraining.size());
            listJudeg.add(listJudgeTraining.get(ranIndex));
        }
        // 整合成一个Map
        Map<String,List<Training>> map = new HashMap<>();
        map.put("single",listSingle);
        map.put("checkbox",listCheckbox);
        map.put("judge",listJudeg);
        return map;
    }
}
