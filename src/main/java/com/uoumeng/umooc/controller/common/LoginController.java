package com.uoumeng.umooc.controller.common;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Student;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.StudentService;
import com.uoumeng.umooc.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/14.
 */
@Controller
@RequestMapping(value = "/access")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public @ResponseBody Result login(@ModelAttribute("student") Student student, HttpServletRequest request){
        if (student.getMobile()==null || student.getPasswd()==null || "".equals(student.getMobile().trim()) || "".equals(student.getPasswd().trim())){
            return new Result(false,"手机号码或密码不能为空");
        }
        Result result = new Result();
        try{
            Map<String,String> map = studentService.login(student.getMobile(), EncryptUtil.getMD5(student.getPasswd()));
            result.setSuccess(true);
            result.setData(map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
        return result;
    }
}
