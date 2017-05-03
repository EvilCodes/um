package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Section;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/5/3.
 */
public interface SectionService {
    /**
     * 根据章ID获取所有的小节，包括视频、练习、形考、项目考。
     * @param chId
     * @return
     */
    Map<String,List<Section>> selectSectionsByChId(Integer chId);

}
