package com.uoumeng.umooc.constant;

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
}
