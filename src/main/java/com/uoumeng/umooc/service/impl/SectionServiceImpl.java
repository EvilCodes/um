package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.*;
import com.uoumeng.umooc.entity.*;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/5/3.
 */
@Service
public class SectionServiceImpl implements SectionService{

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public Map<String,List<Section>> selectSectionsByChId(Integer chId) {
        try{
            List<Section> list = sectionMapper.selectSectionsByChId(chId);
            Map<String,List<Section>> map = new HashMap<>();
            map.put("sections",list);
            return map;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
