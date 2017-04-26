package com.uoumeng.umooc.service;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface ChapterService {
    Map<String,List<?>> selectAllSections(Integer chId);
}
