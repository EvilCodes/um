package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.ProjecttrainingMapper;
import com.uoumeng.umooc.entity.Projecttraining;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.ProjecttrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjun on 2017/5/3.
 */
@Service
public class ProjecttrainingServiceImpl implements ProjecttrainingService{
    @Autowired
    private ProjecttrainingMapper projecttrainingMapper;
    @Override
    public Projecttraining selectProjecttrainingByChId(Integer chId) {
        try{
            Projecttraining pt = projecttrainingMapper.selectProjecttrainingByChId(chId);
            return pt;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
