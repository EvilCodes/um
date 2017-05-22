package com.uoumeng.umooc.controller.busi;

import com.uoumeng.umooc.bean.Result;
import com.uoumeng.umooc.bean.Token;
import com.uoumeng.umooc.entity.Score;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ScoreService;
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
 * Created by chenjun on 2017/5/22.
 */
@Controller
@RequestMapping(value = "/student")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/selectScoresByStuId", method = RequestMethod.GET)
    public @ResponseBody
    Result selectScoresByStuId(HttpServletRequest request) {
        try {
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            List<Map<String,Object>> list = scoreService.selectScoresByStuId(token.getId());
            return new Result(true, list);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/selectScoreByChid", method = RequestMethod.GET)
    public @ResponseBody
    Result selectScoreByChid(@RequestParam("chid") Integer chid, HttpServletRequest request) {
        try {
            String auth = request.getHeader("Authorization");
            Token token = new Token(auth);
            List<Score> list = scoreService.selectScoreByChid(token.getId(),chid);
            return new Result(true, list);
        } catch (MyException e) {
            return new Result(false, e.getMessage());
        }
    }


}
