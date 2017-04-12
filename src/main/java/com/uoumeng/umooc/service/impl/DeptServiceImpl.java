package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.DeptMapper;
import com.uoumeng.umooc.entity.Dept;
import com.uoumeng.umooc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjun on 2017/4/12.
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptDao;

    @Override
    public Dept findDeptById(Integer id) {
        return deptDao.selectByPrimaryKey(id);
    }
}
