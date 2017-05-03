package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Training;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.TrainingService;
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
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    /**
     * 根据小节ID获取练习
     */
    @RequestMapping(value = "/selectTrainingBySeId",method = RequestMethod.GET)
    private @ResponseBody
    Result selectTrainingBySeId(@RequestParam("seId") Integer seId){
        try{
            Map<String,List<Training>> map = trainingService.selectTrainingBySeId(seId);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }

    /**
     * 根据章ID获取整章形式考试
     */
    @RequestMapping(value = "/selectFormalExamByChId",method = RequestMethod.GET)
    private @ResponseBody
    Result selectFormalExamByChId(@RequestParam("chId") Integer chId){
        try{
            Map<String,List<Training>> map = trainingService.selectTrainingBySeId(chId);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }

}
