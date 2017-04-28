package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.ChapterMapper;
import com.uoumeng.umooc.dao.TrainingsectionMapper;
import com.uoumeng.umooc.dao.VideosectionMapper;
import com.uoumeng.umooc.entity.Chapter;
import com.uoumeng.umooc.entity.Trainingsection;
import com.uoumeng.umooc.entity.Videosection;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
@Service
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private VideosectionMapper videosectionMapper;

    @Autowired
    private TrainingsectionMapper trainingsectionMapper;

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public Map<String, List<?>> selectAllSections(Integer chId) {
        try{
            Map<String,List<?>> map = new HashMap<>();
            List<Videosection> listVideo = videosectionMapper.selectAllVediosectionByChId(chId);
            List<Trainingsection> listTraining = trainingsectionMapper.selectAllTrainingsectionByChId(chId);
            map.put("listVideo",listVideo);
            map.put("listTraining",listTraining);
            return map;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public List<Chapter> selectAllChapters() {
        try{
            List<Chapter> list = chapterMapper.selectAllChapters();
            return  list;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
