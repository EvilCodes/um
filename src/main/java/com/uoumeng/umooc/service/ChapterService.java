package com.uoumeng.umooc.service;

import com.uoumeng.umooc.bean.StudentChapter;

import java.util.List;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface ChapterService {
    /**
     * 根据学生ID查找学生所学章节进度
     * @param sid
     * @return
     */
    List<StudentChapter> selectStudentChapters(Integer sid);
}
