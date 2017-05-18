package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Address;

import java.util.List;

/**
 * Created by chenjun on 2017/5/18.
 */
public interface AddressService {

    boolean deleteById(Integer id,Integer sid);

    boolean insertAddress(Address record);

    Address selectById(Integer id);

    boolean updateAddress(Address record);

    List<Address> selectAddressByStuId(Integer sid);
}
