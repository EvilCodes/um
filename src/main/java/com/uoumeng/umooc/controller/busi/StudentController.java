package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Student;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenjun on 2017/4/25.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public @ResponseBody
    Result updateStudent(@ModelAttribute("student") Student student){
        Result result = new Result();
        try{
            boolean flag = studentService.updateStudent(student);
            result.setSuccess(flag);
            if(flag){
                result.setError("update student success");
            }else{
                result.setError("update student failed");
            }
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/selectStudentById",method = RequestMethod.GET)
    public @ResponseBody Result selectStudentById(HttpServletRequest request){
        Result result = new Result();
        try{
            // 从请求头的加密字符串中获取学生Id
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            Student student
             = studentService.selectStudentById(token.getId());
            result.setSuccess(true);
            result.setData(student);
        } catch(MyException e){
            return  new Result(false,e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "updatePasswd",method = RequestMethod.POST)
    public @ResponseBody Result updatePasswd(@RequestParam("opasswd") String opasswd, @RequestParam("npasswd1") String npasswd1, @RequestParam("npasswd2") String npasswd2, HttpServletRequest request){
        try{
            if(!npasswd1.equals(npasswd2)){
                return new Result(false,"两次密码不一致");
            }
            if(opasswd.equals(npasswd1)){
                return new Result(false,"新旧密码相同");
            }
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            boolean flag = studentService.updatePasswd(npasswd1,token.getId());
            return new Result(flag,"更新密码成功");
        } catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
