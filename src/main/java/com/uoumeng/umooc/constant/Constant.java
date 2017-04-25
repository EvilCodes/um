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

}
