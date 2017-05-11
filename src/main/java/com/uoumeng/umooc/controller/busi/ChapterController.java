package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.StudentChapter;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/selectStudentChapters",method = RequestMethod.GET)
    private @ResponseBody
    Result selectStudentChapters(HttpServletRequest request){
        try{
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            List<StudentChapter> list = chapterService.selectStudentChapters(token.getId());
            Map<String,List<StudentChapter>> map = new HashMap<>();
            map.put("chapters",list);
            return new Result(true,map);
        }catch(MyException e){
            return new Result(false,e.getMessage());
        }
    }
}
