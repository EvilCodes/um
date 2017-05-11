package com.uoumeng.umooc.constant;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenjun on 2017/4/14.
 */
public interface Constant {
    /**
     * jwt
     */
//    public static final String JWT_ID = "jwt";
    String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    int JWT_TTL = 60*60*1000;  //millisecond
    int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond

    /** 学生角色名称 **/
    String STUDENT_ROLE = "student";

    /** 题目类型 **/
    String QUESTION_TYPE_SINGLR = "1";// 单选
    String QUESTION_TYPE_CHECKBOX = "2"; // 多选
    String QUESTION_TYPE_JUDGE = "3";// 判断题

    /** 练习中题目的数量 **/
    int NUMBER_SINGLE_TRAINSECTION = 2; // 单选题数量
    int NUMBER_CHECKBOX_TRAINSECTION = 1; // 多选题数量
    int NUMBER_JUDGE_TRAINSECTION = 1; // 判断题数量

    /** 形式考试中的题目的数量 **/
    int NUMBER_SINGLE_FORMALEXAM = 2; // 单选题数量
    int NUMBER_CHECKBOX_FORMALEXAM = 1; // 多选题数量
    int NUMBER_JUDGE_FORMALEXAM = 2; // 判断题数量

    /** 练习中的各试题的分数 **/
    int SCORE_SINGLE_TRAINING = 1; // 单选1分
    int SCORE_CHECKBOX_ALL_TRAINING = 2; // 多选全对2分
    int SCORE_CHECKBOX_HALF_TRAINING = 1; // 多选半对2分
    int SCORE_JUDGE_TRAINING = 1; // 判断1分

    /** 形式考试中的各试题分数 **/
    int SCORE_SINGLE_FORMALEXAM = 1; // 单选1分
    int SCORE_CHECKBOX_ALL_FORMALEXAM = 2; // 多选全对2分
    int SCORE_CHECKBOX_HALF_FORMALEXAM = 1; // 多选半对2分
    int SCORE_JUDGE_FORMALEXAM = 1; // 判断1分


    /** 得分原因 **/
    String REASON_SCORE_TRAINING = "课后练习";

    /** 考试类型 **/
    String TYPE_FORMAL_EXAM = "1";// 形式考试
    String TYPE_PROJECT_EXAM = "2";// 项目考试

    /** 形考通过的及格分 **/
    int SCORE_PASS_FORMAL_EXAM = 40;
    /** 项目考试通过的及格分 **/
    int SCORE_PASS_PROJECT_EXAM = 60;

    /** 哪些章只有形式考试没有项目考试 **/
    List<Integer> LIST_CHAPTER_ONLY_FORMAL_EXAM = Arrays.asList(new Integer[]{1,11,12,13,14,15});

    /** 章的状态1、已经学完 2、正在学习 3、还不能学 **/
    String STATUS_CHAPTER_YES = "1";
    /** 正在学习 **/
    String STATUS_CHAPTER_ING = "2";
    /** 还不能学 **/
    String STATUS_CHAPTER_NO = "3";

}
