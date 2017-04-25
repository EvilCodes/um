package com.uoumeng.umooc.service;

import java.util.Map;

/**
 * Created by chenjun on 2017/4/14.
 */
public interface StudentService {
    Map<String,String> login(String mobile,String passwd);
}
