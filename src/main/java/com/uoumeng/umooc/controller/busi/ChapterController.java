package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Chapter;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
@Controller
@RequestMapping(value = "/student")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping(value = "/selectAllSections",method = RequestMethod.GET)
    private @ResponseBody
    Result selectAllSections(@RequestParam("chId") Integer chId){
        try{
            Map<String,List<?>> map = chapterService.selectAllSections(chId);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }

    @RequestMapping(value = "/selectAllChapters",method = RequestMethod.GET)
    private @ResponseBody
    Result selectAllChapters(){
        try{
            List<Chapter> list = chapterService.selectAllChapters();
            Map<String,List<Chapter>> map = new HashMap<>();
            map.put("chapters",list);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
