package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Employee;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenjun on 2017/4/25.
 */
@Controller
@RequestMapping(value = "/student")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/selectTeacherByStuId",method = RequestMethod.GET)
    public @ResponseBody
    Result selectTeacherByStuId(@RequestHeader("Authorization") String token){
        Integer stuId = new Token(token).getId();
        try{
            Employee teacher = employeeService.selectTeacherByStuId(stuId);
            return new Result(true,teacher);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
