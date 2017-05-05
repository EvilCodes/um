package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.bean.Answer;
import com.uoumeng.umooc.bean.CheckBoxAnswer;
import com.uoumeng.umooc.bean.JudgeAnswer;
import com.uoumeng.umooc.bean.SingleAnswer;
import com.uoumeng.umooc.constant.Constant;
import com.uoumeng.umooc.dao.CreditMapper;
import com.uoumeng.umooc.dao.TrainingMapper;
import com.uoumeng.umooc.entity.Credit;
import com.uoumeng.umooc.entity.Training;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by chenjun on 2017/4/26.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingMapper trainingMapper;

    @Autowired
    private CreditMapper creditMapper;

    @Override
    public Map<String, List<Training>> selectTrainingBySeId(Integer seId) {
        try{
            List<Training> list = trainingMapper.selectTrainingBySeId(seId);
            Map<String,List<Training>> map = randomTraining(list,Constant.NUMBER_SINGLE_TRAINSECTION,Constant.NUMBER_CHECKBOX_TRAINSECTION,Constant.NUMBER_JUDGE_TRAINSECTION);
            return map;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public Map<String, List<Training>> selectFormalExamByChId(Integer chId) {
        try{
            List<Training> list = trainingMapper.selectFormalExamByChId(chId);
            Map<String,List<Training>> map = randomTraining(list,Constant.NUMBER_SINGLE_FORMALEXAM,Constant.NUMBER_CHECKBOX_FORMALEXAM,Constant.NUMBER_JUDGE_FORMALEXAM);
            return map;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }


    @Override
    public Map<String, Integer> correctTraining(Answer answer,int sid) {
        try{
            // 计算总分
            int totalScore = correctTraining(answer);
            // 记录学分
            Credit credit = new Credit();
            credit.setAmount(totalScore);
            credit.setChid(Integer.parseInt(answer.getChId()));
            credit.setSeid(Integer.parseInt(answer.getSeId()));
            credit.setCtime(new Date());
            credit.setReason(Constant.REASON_SCORE_TRAINING);
            credit.setSid(sid);
            creditMapper.insert(credit);
            Map<String,Integer> map = new HashMap<String, Integer>();
            map.put("score",totalScore);
            // 返回Map
            return map;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    /**
     * 三种题型判分
     * @return 总分
     */
    public int correctTraining(Answer answer){
        List<SingleAnswer> listSingle = answer.getSingle();
        List<CheckBoxAnswer> listCheckbox = answer.getCheckbox();
        List<JudgeAnswer> listJudge = answer.getJudge();
        return correctSingle(listSingle,Constant.SCORE_SINGLE_TRAINING)
                + correctCheckbox(listCheckbox,Constant.SCORE_CHECKBOX_ALL_TRAINING,Constant.SCORE_CHECKBOX_HALF_TRAINING)
                + correctJudge(listJudge,Constant.SCORE_JUDGE_TRAINING);
    }

    /**
     * 单选题得分
     * @param list
     * @return
     */
    public int correctSingle(List<SingleAnswer> list,int singleScore){
        int score = 0;
        for(SingleAnswer sa : list){
            Training training = trainingMapper.selectByPrimaryKey(Integer.parseInt(sa.getId()));
            if(sa.getChecked().equals(training.getAnswer())){
                // 答对+1分
                score += singleScore;
            }
        }
        return score;
    }

    /**
     * 多选题判分
     * 全对两分、半对1分
     * @param list
     * @return
     */
    public int correctCheckbox(List<CheckBoxAnswer> list,int allScore,int halfScore){
        int score = 0;
        for(CheckBoxAnswer ca : list){
            Training training = trainingMapper.selectByPrimaryKey(Integer.parseInt(ca.getId()));
            List<String> listAnswer = ca.getChecked();
            String strAnswer = "";
            boolean flag = true;
            // 错误没有分
            for(String answer : listAnswer){
                strAnswer += answer;
                if(!training.getAnswer().contains(answer)){
                    flag = false;
                }
            }
            if(flag){
                if(strAnswer.length()==training.getAnswer().length()){
                    // 全对2分
                    score += allScore;
                }else{
                    // 半对1分
                    score += halfScore;
                }
            }
        }
        return score;
    }

    /**
     * 判断题判分
     * @param list
     * @return
     */
    public int correctJudge(List<JudgeAnswer> list,int judgeScore){
        int score = 0;
        for(JudgeAnswer ja : list){
            Training training = trainingMapper.selectByPrimaryKey(Integer.parseInt(ja.getId()));
            if(training.getAnswer().equalsIgnoreCase(ja.getChecked())){
                // 答对+1分
                score += judgeScore;
            }
        }
        return score;
    }



    /**
     * 将从数据库中取出的所有题目
     * 随机得到指定数量的单选题、多选题和判断题
     * @param list
     * @return
     */
    private Map<String,List<Training>> randomTraining(List<Training> list,int num_single,int num_checkbox,int num_judge){
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
        for(int i=0;i<num_single;i++){
            int ranIndex = ran.nextInt(listSingleTraining.size());
            listSingle.add(listSingleTraining.get(ranIndex));
        }
        // 随机1道多选题并存储
        for(int i=0;i<num_checkbox;i++){
            int ranIndex = ran.nextInt(listCheckboxTraining.size());
            listCheckbox.add(listCheckboxTraining.get(ranIndex));
        }
        // 随机1道判断题并存储
        for(int i=0;i<num_judge;i++){
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
