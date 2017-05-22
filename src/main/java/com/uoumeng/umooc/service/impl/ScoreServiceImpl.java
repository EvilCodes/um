package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.ScoreMapper;
import com.uoumeng.umooc.entity.Score;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/5/22.
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public List<Map<String, Object>> selectScoresByStuId(Integer sid) {
        try{
            List<Map<String,Object>> list = scoreMapper.selectScoresByStuId(sid);
            return list;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public List<Score> selectScoreByChid(Integer sid, Integer chid) {
        try{
            List<Score> list = scoreMapper.selectScoreByChid(sid,chid);
            return list;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
