package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Employee;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}