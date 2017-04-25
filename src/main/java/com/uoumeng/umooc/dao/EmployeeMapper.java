package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Employee;

public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectTeacherByStuId(Integer stuId);
}