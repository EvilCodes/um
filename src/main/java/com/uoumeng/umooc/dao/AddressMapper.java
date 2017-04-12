package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Address;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}