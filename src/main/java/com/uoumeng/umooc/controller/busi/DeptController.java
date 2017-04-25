package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.entity.Dept;
import com.uoumeng.umooc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenjun on 2017/4/12.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    private @ResponseBody Dept findDeptById( @RequestParam("id") Integer id){
        System.out.println("Hello");
        return deptService.findDeptById(id);
    }
}
