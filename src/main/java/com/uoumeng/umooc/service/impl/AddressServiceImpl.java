package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.AddressMapper;
import com.uoumeng.umooc.entity.Address;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenjun on 2017/5/18.
 */
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public boolean deleteById(Integer id,Integer sid) {
        try{
            int n = addressMapper.deleteByPrimaryKey(id,sid);
            if(n==1){
                return true;
            }else{
                throw new MyException("删除地址失败");
            }
        } catch(MyException e){
            throw e;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public boolean insertAddress(Address record) {
        try{
            int n = addressMapper.insert(record);
            if(n==1){
                return true;
            }else{
                throw new MyException("添加地址失败");
            }
        } catch(MyException e){
            throw e;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public Address selectById(Integer id) {
        try{
            Address address = addressMapper.selectByPrimaryKey(id);
            if(address != null){
                return address;
            }else{
                throw new MyException("查找单个地址失败");
            }
        } catch(MyException e){
            throw e;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public boolean updateAddress(Address record) {
        try{
            int  n = addressMapper.updateByPrimaryKeySelective(record);
            if(n == 1){
                return true;
            }else{
                throw new MyException("修改地址失败");
            }
        } catch(MyException e){
            throw e;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }

    @Override
    public List<Address> selectAddressByStuId(Integer sid) {
        try{
            List<Address> addressList = addressMapper.selectAddressByStuId(sid);
            if(addressList != null){
                return addressList;
            }else{
                throw new MyException("查找学生全部地址失败");
            }
        } catch(MyException e){
            throw e;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
