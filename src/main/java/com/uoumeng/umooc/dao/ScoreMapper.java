package com.uoumeng.umooc.dao;

import com.uoumeng.umooc.entity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    /**
     * 根据学生ID查找该学生所有的形考或项目考成绩
     * @param sid
     * @param type
     * @return
     */
    List<Score> selectFormalExamScores(@Param("sid") Integer sid, @Param("type") String type);

    /**
     * 根据学生ID和章ID，查询某一章的形考及项目考成绩
     * @param sid
     * @param chid
     * @return
     */
    List<Score> selectScoreByChid(@Param("sid") Integer sid,@Param("chid") Integer chid);

    /**
     * 根据学生ID查找该学生所有章的汇总成绩
     * @param sid
     * @return
     */
    List<Map<String,Object>> selectScoresByStuId(Integer sid);


}