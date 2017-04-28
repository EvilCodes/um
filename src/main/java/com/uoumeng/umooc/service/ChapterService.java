package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Chapter;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface ChapterService {
    /**
     * 根据章ID获取所有的视频小节和练习小节
     * @param chId
     * @return
     */
    Map<String,List<?>> selectAllSections(Integer chId);

    List<Chapter> selectAllChapters();
}
