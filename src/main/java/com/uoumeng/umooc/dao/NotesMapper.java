package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Notes;

public interface NotesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notes record);

    int insertSelective(Notes record);

    Notes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notes record);

    int updateByPrimaryKey(Notes record);

    /**
     * 根据小节ID获取笔记
     * @param seId
     * @return
     */
    Notes selectNoteBySeId(Integer seId);
}