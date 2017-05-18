package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Student;

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


    /**
     * 更新学生个人信息
     * @param student
     * @return 是否更新成功
     */
    boolean updateStudent(Student student);

    /**
     * 根据Id查找学生信息
     * @param id
     * @return
     */
    Student selectStudentById(Integer id);
}
