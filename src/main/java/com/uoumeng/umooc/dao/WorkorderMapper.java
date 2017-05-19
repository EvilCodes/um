package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Workorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workorder record);

    int insertSelective(Workorder record);

    Workorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workorder record);

    int updateByPrimaryKey(Workorder record);

    List<Workorder> selectWorkorderByStuId(@Param("sid") Integer sid, @Param("startRow") int startRow, @Param("pageSize") int pageSize);

    int selectCountWorkorder(Integer sid);
}