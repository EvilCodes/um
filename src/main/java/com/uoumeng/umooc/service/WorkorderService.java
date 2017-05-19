package com.uoumeng.umooc.service;

import com.uoumeng.umooc.bean.Page;
import com.uoumeng.umooc.entity.Workorder;

/**
 * Created by chenjun on 2017/5/18.
 */
public interface WorkorderService {
    /**
     * 添加工单
     * @param workorder
     * @return
     */
    boolean insertWorkorder(Workorder workorder);

    /**
     * 根据ID删除某工单
     * @param id
     * @return
     */
    boolean deleteWorkorder(Integer id);

    /**
     * 分页查询某个学生的全部工单
     * @return
     */
    Page<Workorder> selectWorkorderByStuId(Integer sid, Page page);
}
