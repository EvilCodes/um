package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    int deleteByPrimaryKey(@Param("id") Integer id,@Param("sid") Integer sid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAddressByStuId(Integer sid);
}