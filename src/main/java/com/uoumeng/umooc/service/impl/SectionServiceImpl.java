package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.bean.StudentSection;
import com.uoumeng.umooc.constant.Constant;
import com.uoumeng.umooc.dao.*;
import com.uoumeng.umooc.entity.*;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Map<String,List<StudentSection>> selectSectionsByChId(Integer chId, Integer stuId) {
        try{
            // 从数据库中取出某个学生的某章的所有小节
            List<HashMap> list = sectionMapper.selectSectionsByChId(chId,stuId);
            // 将取出的数据封装为StudentSection的List集合
            List<StudentSection> sectionList = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                HashMap map = list.get(i);
                StudentSection studentSection = new StudentSection();
                studentSection.setChid((Integer) map.get("chid"));
                studentSection.setSeid((Integer) map.get("seid"));
                studentSection.setSename((String) map.get("sename"));
                studentSection.setSetype((String) map.get("setype"));
                studentSection.setSerno((Integer) map.get("serno"));
                Object obj = map.get("cid");
                if(obj==null){
                    // 没有对应学分，则表示没学过
                    studentSection.setFlag(Constant.STATUS_SECTION_NO);
                }else{
                    // 有对应学分则表示已经学习完成
                    studentSection.setFlag(Constant.STATUS_CHAPTER_YES);
                }
                sectionList.add(studentSection);
            }
            // 如果某一节学完，则把后一节置为正在学习
            for(int i=0;i<sectionList.size()-1;i++){// 最后一节无需处理
                if(sectionList.get(i).getFlag().equals(Constant.STATUS_SECTION_YES) && sectionList.get(i+1).getFlag()==null){
                    sectionList.get(i+1).setFlag(Constant.STATUS_SECTION_ING);
                }
            }

            Map<String,List<StudentSection>> map = new HashMap<>();
            map.put("sections",sectionList);
            return map;
        }catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
