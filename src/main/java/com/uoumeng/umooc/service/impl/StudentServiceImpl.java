package com.uoumeng.umooc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.constant.Constant;
import com.uoumeng.umooc.dao.StudentMapper;
import com.uoumeng.umooc.entity.Student;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.StudentService;
import com.uoumeng.umooc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/14.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private StudentMapper studentMapper;

    public Map<String, String> login(Student student) {
        Result<String> result = new Result<>();
        try {
            Student stu = studentMapper.selectByMobile(student.getMobile(),student.getPasswd());
            if(stu!=null){
                Map<String,Object> map  = new HashMap<>();
                map.put("id",stu.getId());
                map.put("mobile",stu.getMobile());
                map.put("nick",stu.getNick());
                String token = jwt.createJWT(Constant.JWT_ID,Constant.JWT_TTL,map);
                String refreshToken = jwt.createJWT(Constant.JWT_ID, Constant.JWT_REFRESH_TTL,map);
                Map<String,String> mapResult = new HashMap<String, String>();
                JSONObject jo = new JSONObject();
                mapResult.put("token", token);
                mapResult.put("refreshToken", refreshToken);
                return mapResult;
            }else{
                throw new MyException("用户名或密码不存在");
            }
        } catch(MyException e){
            // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制层无法具体识别是哪个异常
            throw e;
        }catch (Exception e) {
            // 所有编译期异常转换为运行期异常
            throw new MyException("error:" + e.getMessage());
        }
    }
}
