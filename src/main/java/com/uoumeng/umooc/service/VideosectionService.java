package com.uoumeng.umooc.service;

import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface VideosectionService {
    /**
     * 根据视频小节ID获取视频播放界面信息：
     * 视频信息、自动笔记、常见问题、资源下载。
     * @param seId
     * @return
     */
    Map<String, Object> selectVideosectionInfo(Integer seId);
}
