package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Employee;

/**
 * Created by chenjun on 2017/4/25.
 */
public interface EmployeeService {

    /**
     * 根据学生ID获取专属老师
     * @param stuId
     * @return
     */
    Employee selectTeacherByStuId(Integer stuId);
}
