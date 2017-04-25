package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Employee;

import java.util.Map;

/**
 * Created by chenjun on 2017/4/14.
 */
public interface StudentService {
    /***
     * 登陆
     * @param mobile
     * @param passwd
     * @return
     */
    Map<String,String> login(String mobile,String passwd);

}
