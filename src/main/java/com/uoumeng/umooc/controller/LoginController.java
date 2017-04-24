package com.uoumeng.umooc.controller;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Student;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by chenjun on 2017/4/14.
 */
@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody Result login(@ModelAttribute("student") Student student){
        System.out.println(student);
        if (student.getMobile()==null || student.getPasswd()==null || "".equals(student.getMobile()) || "".equals(student.getPasswd())){
            return new Result(false,"手机号码或密码不能为空");
        }
        Result result = new Result();
        try{
            Map<String,String> map = studentService.login(student);
            result.setSuccess(true);
            result.setData(map);
        }catch(MyException e){
            System.out.println(result);
            return new Result(false,e.getMessage());
        }
        System.out.println(result);
        return result;
    }
}
