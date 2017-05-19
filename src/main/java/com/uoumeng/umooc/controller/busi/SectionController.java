package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.StudentSection;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/selectSections",method = RequestMethod.GET)
    public @ResponseBody
    Result selectSectionsByChId(@RequestParam("chId") Integer chId,HttpServletRequest request){
        try{
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            Map<String,List<StudentSection>> map = sectionService.selectSectionsByChId(chId,token.getId());
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
