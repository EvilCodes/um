package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Answer;
import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Training;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public @ResponseBody
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

    /**
     * 批改小节练习，返回分数
      */
    @RequestMapping(value = "/correctTraining",method = RequestMethod.POST)
    private @ResponseBody
    Result correctTraining(@RequestBody Answer answer, HttpServletRequest request){
        if(answer==null){
            return new Result(false,"参数有误！");
        }
        try{
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            Map<String,Integer> map = trainingService.correctTraining(answer,token.getId());
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }

    /**
     * 形式考试判分
     * @param answer
     * @param request
     * @return
     */
    @RequestMapping(value = "/correctFormalExam",method = RequestMethod.POST)
    private @ResponseBody
    Result correctFormalExam(@RequestBody Answer answer, HttpServletRequest request){
        if(answer==null){
            return new Result(false,"参数有误！");
        }
        try{
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            Map<String,Object> map = trainingService.correctFormalExam(answer,token.getId());
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }

    /**
     * 添加考题
     */
    @RequestMapping(value = "/addTraining",method = RequestMethod.POST)
    private @ResponseBody Result addTraining(@ModelAttribute("training") Training training){
        try{
            if(training!=null){
                return new Result(false,"参数有误!");
            }
            if(trainingService.addTraining(training)){
                return new Result(true,"添加成功");
            }else{
                return new Result(false,"添加失败");
            }
        } catch(MyException e){
            return new Result(false,e.getMessage());
        } catch(Exception e){
            return new Result(false,e.getMessage());
        }
    }
}
