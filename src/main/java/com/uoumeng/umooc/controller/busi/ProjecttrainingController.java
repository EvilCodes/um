package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Projecttraining;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ProjecttrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenjun on 2017/5/3.
 */
@Controller
@RequestMapping(value = "/student")
public class ProjecttrainingController {
    @Autowired
    private ProjecttrainingService projecttrainingService;

    @RequestMapping(value = "/selectProjecttrainingByChId",method = RequestMethod.GET)
    private @ResponseBody
    Result selectProjecttrainingByChId(@RequestParam("chId") Integer chId){
        try{
            Projecttraining pt = projecttrainingService.selectProjecttrainingByChId(chId);
            return new Result(true,pt);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
