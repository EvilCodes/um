package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.EmployeeMapper;
import com.uoumeng.umooc.entity.Employee;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjun on 2017/4/25.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee selectTeacherByStuId(Integer stuId) {
        try{
            Employee teacher = employeeMapper.selectTeacherByStuId(stuId);
            if(teacher==null){
                throw new MyException("没有对应专属老师，请联系管理员");
            }
            return teacher;
        }catch (MyException e){
            throw e;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
