package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Assets;

public interface AssetsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKey(Assets record);

    Assets selectAssetsBySeId(Integer seId);
}