package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Currency;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurrencyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Currency record);

    int insertSelective(Currency record);

    Currency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Currency record);

    int updateByPrimaryKey(Currency record);
}