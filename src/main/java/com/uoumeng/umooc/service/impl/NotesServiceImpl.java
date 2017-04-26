package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.NotesMapper;
import com.uoumeng.umooc.entity.Notes;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjun on 2017/4/26.
 */
@Service
public class NotesServiceImpl implements NotesService{
    @Autowired
    private NotesMapper notesMapper;

//    public Notes selectNoteBySeId(Integer seId) {
        /*try{
            Notes notes = notesMapper.selectNoteBySeId(seId);
            if(notes==null){
                throw new MyException("查询笔记有误");
            }
            return notes;
        } catch(MyException e){
            throw e;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }*/
//    }
}
