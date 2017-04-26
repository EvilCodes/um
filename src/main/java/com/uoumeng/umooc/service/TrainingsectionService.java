package com.uoumeng.umooc.service;

import com.uoumeng.umooc.entity.Training;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjun on 2017/4/26.
 */
public interface TrainingsectionService {
    Map<String,List<Training>> selectTrainingBySeId(Integer seId);
}
