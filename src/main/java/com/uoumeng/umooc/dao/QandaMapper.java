package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Qanda;

public interface QandaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qanda record);

    int insertSelective(Qanda record);

    Qanda selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qanda record);

    int updateByPrimaryKey(Qanda record);

    /**
     * 根据小节ID查询常见问题
     * @param seId
     * @return
     */
    Qanda selectQandaBySeId(Integer seId);
}