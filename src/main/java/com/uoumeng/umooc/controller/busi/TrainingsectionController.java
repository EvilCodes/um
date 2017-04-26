package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Training;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.TrainingsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
@Controller
@RequestMapping(value = "/student")
public class TrainingsectionController {
    @Autowired
    private TrainingsectionService trainingsectionService;

    @RequestMapping(value = "/selectTrainingBySeId",method = RequestMethod.GET)
    private @ResponseBody
    Result selectTeacherByStuId(@RequestParam("seId") Integer seId){
        try{
            Map<String,List<Training>> map = trainingsectionService.selectTrainingBySeId(seId);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
