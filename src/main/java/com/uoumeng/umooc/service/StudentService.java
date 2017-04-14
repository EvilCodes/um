package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Student;

import java.util.Map;

/**
 * Created by chenjun on 2017/4/14.
 */
public interface StudentService {
    Map<String,String> login(Student student);
}
