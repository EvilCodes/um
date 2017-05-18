package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Student;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
