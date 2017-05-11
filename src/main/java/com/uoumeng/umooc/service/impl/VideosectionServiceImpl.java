package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.dao.NotesMapper;
import com.uoumeng.umooc.dao.QandaMapper;
import com.uoumeng.umooc.dao.AssetsMapper;
import com.uoumeng.umooc.dao.VideoMapper;
import com.uoumeng.umooc.entity.Notes;
import com.uoumeng.umooc.entity.Qanda;
import com.uoumeng.umooc.entity.Assets;
import com.uoumeng.umooc.entity.Video;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.VideosectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
@Service
public class VideosectionServiceImpl implements VideosectionService{

    @Autowired
    private NotesMapper notesMapper;
    @Autowired
    private QandaMapper qandaMapper;
    @Autowired
    private AssetsMapper assetsMapper;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Map<String, Object> selectVideosectionInfo(Integer seId) {
        try{
            Map<String,Object> map = new HashMap<>();
            Notes notes = notesMapper.selectNoteBySeId(seId);
            Qanda qanda = qandaMapper.selectQandaBySeId(seId);
            Assets assets = assetsMapper.selectAssetsBySeId(seId);
            Video video = videoMapper.selectBySeId(seId);
            map.put("notes",notes);
            map.put("qanda",qanda);
            map.put("assets",assets);
            map.put("video",video);
            return map;
        } catch(Exception e){
            throw new MyException("系统错误："+e.getMessage());
        }
    }
}
