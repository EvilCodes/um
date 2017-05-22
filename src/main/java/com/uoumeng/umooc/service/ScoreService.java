package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Score;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/5/22.
 */
public interface ScoreService {
    List<Map<String, Object>> selectScoresByStuId(Integer sid);

    List<Score> selectScoreByChid(Integer sid, Integer chid);
}
