package com.uoumeng.umooc.service;

import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface VideosectionService {
    /**
     * 根据小节ID获取小节信息，
     * 包括：视频信息、自动笔记、常见问题、下载资源
     * @param seId 视频小节ID
     * @return
     */
    Map<String,Object> selectVideosectionInfo(Integer seId);
}
