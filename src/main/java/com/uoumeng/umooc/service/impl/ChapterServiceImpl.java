package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.bean.StudentChapter;
import com.uoumeng.umooc.constant.Constant;
import com.uoumeng.umooc.dao.ChapterMapper;
import com.uoumeng.umooc.dao.ScoreMapper;
import com.uoumeng.umooc.entity.Chapter;
import com.uoumeng.umooc.entity.Score;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjun on 2017/4/26.
 */
@Service
public class ChapterServiceImpl implements ChapterService{

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private ScoreMapper scoreMapper;

      @Override
      public List<StudentChapter> selectStudentChapters(Integer sid){
        try{
            // 获取所有的章节
            List<Chapter> listChapters = chapterMapper.selectAllChapters();
            // 获取所有的形考成绩
            List<Score> listFormalScores = scoreMapper.selectFormalExamScores(sid, Constant.TYPE_FORMAL_EXAM);
            // 获取所有的项目考试成绩
            List<Score> listProjectScores = scoreMapper.selectFormalExamScores(sid,Constant.TYPE_PROJECT_EXAM);
            List<StudentChapter> listStudentChapters = new ArrayList<>();
            // 定义后面一章是否可以学习
            boolean flagLastChapter = true;
            for(Chapter chapter : listChapters){
                StudentChapter studentChapter = new StudentChapter();
                if(flagLastChapter){
                    studentChapter.setFlag(Constant.STATUS_CHAPTER_ING);
                    flagLastChapter = false;
                }
                studentChapter.setChid(chapter.getId());
                studentChapter.setChname(chapter.getName());
                studentChapter.setChdesc(chapter.getCdesc());
                // 获取指定章的形式考试分数
                Integer formalScore = findScore(listFormalScores,chapter.getId());
                studentChapter.setFormalScore(formalScore);
                // 获取指定章的项目考试分数
                Integer projectScore = findScore(listProjectScores,chapter.getId());
                studentChapter.setProjectScore(projectScore);
                // 根据本课程的特点，修改返回数据如下：
                if(Constant.LIST_CHAPTER_ONLY_FORMAL_EXAM.contains(chapter.getId())){
                    // 第1、11、12、13、14、15章没有项目考试分数
                    studentChapter.setProjectScore(null);
                    // 对于上面这些章，如果形式考试>=40分，以为着通过了本章的学习
                    if(formalScore >= Constant.SCORE_PASS_FORMAL_EXAM){
                        // 已经学完
                         studentChapter.setFlag(Constant.STATUS_CHAPTER_YES);
                        // 如果通过了考试，则后面一章也解锁
                        flagLastChapter = true;
                    }
                }else{
                    // 对于其他章，形式考试大于等于40分，并且项目考试大于等于60分才算通过考试
                    if(formalScore >= Constant.SCORE_PASS_FORMAL_EXAM && projectScore >= Constant.SCORE_PASS_PROJECT_EXAM){
                        // 已经学完
                        studentChapter.setFlag(Constant.STATUS_CHAPTER_YES);
                        flagLastChapter = true;
                    }
                }
                listStudentChapters.add(studentChapter);
            }
            return  listStudentChapters;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    public Integer findScore(List<Score> scoreList,Integer chid){
          for(Score score : scoreList){
              if(score.getChid().equals(chid)){
                  return score.getScore();
              }
          }
          return 0;
    }
}
