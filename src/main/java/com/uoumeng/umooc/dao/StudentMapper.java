package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByMobile(@Param("mobile") String mobile, @Param("passwd") String passwd);
}