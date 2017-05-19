package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Page;
import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Workorder;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.WorkorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenjun on 2017/5/19.
 */
@Controller
@RequestMapping(value = "/student")
public class WorkorderController {

    @Autowired
    private WorkorderService workorderService;

    @RequestMapping(value = "/selectWorkorderByStuId",method = RequestMethod.GET)
    public @ResponseBody
    Result selectWorkorderByStuId(@ModelAttribute("page") Page page, HttpServletRequest request){
        try{
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            Page<Workorder> pageResult = workorderService.selectWorkorderByStuId(token.getId(),page);
            return new Result(true,pageResult);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
