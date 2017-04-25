package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.constant.Constant;
import com.uoumeng.umooc.dao.StudentMapper;
import com.uoumeng.umooc.entity.Employee;
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

    public Map<String, String> login(String mobile,String passwd) {
        try {
            Student stu = studentMapper.selectByMobile(mobile,passwd);
            if(stu!=null){
                Map<String,Object> map  = new HashMap<>();
                map.put("id",stu.getId());
                map.put("mobile",stu.getMobile());
                map.put("nick",stu.getNick());
                map.put("role",Constant.STUDENT_ROLE);
                String token = jwt.createJWT(Constant.JWT_TTL,map);
                String refreshToken = jwt.createJWT(Constant.JWT_REFRESH_TTL,map);
                Map<String,String> mapResult = new HashMap<String, String>();
                mapResult.put("token", token);
                mapResult.put("refreshToken", refreshToken);
                return mapResult;
            }else{
                throw new MyException("用户名或密码不存在");
            }
        } catch(MyException e){
            // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为MyException，导致控制层无法具体识别是哪个异常
            throw e;
        }catch (Exception e) {
            // 所有编译期异常转换为运行期异常
            throw new MyException("error:" + e.getMessage());
        }
    }

}
