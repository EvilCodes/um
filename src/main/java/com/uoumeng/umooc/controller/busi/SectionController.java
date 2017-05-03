package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.entity.Section;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/5/3.
 */
@Controller
@RequestMapping(value = "/student")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = "/selectSectionsByChId",method = RequestMethod.GET)
    private @ResponseBody
    Result selectSectionsByChId(@RequestParam("chId") Integer chId){
        try{
            Map<String,List<Section>> map = sectionService.selectSectionsByChId(chId);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
