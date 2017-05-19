package com.uoumeng.umooc.service.impl;

import com.uoumeng.umooc.bean.Page;
import com.uoumeng.umooc.dao.WorkorderMapper;
import com.uoumeng.umooc.entity.Workorder;
import com.uoumeng.umooc.exception.MyException;
import com.uoumeng.umooc.service.WorkorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chenjun on 2017/5/18.
 */
@Service
public class WorkorderServiceImpl implements WorkorderService {

    @Autowired
    private WorkorderMapper workorderMapper;

    @Override
    public boolean insertWorkorder(Workorder workorder) {
        try {
            // 设置工单提交时间为当前时间
            workorder.setAtime(new Date());
            int n = workorderMapper.insert(workorder);
            if (n == 1) {
                return true;
            } else {
                throw new MyException("添加工单失败");
            }
        } catch (MyException e) {
            throw e;
        } catch (Exception e) {
            throw new MyException("系统错误：" + e.getMessage());
        }
    }

    @Override
    public boolean deleteWorkorder(Integer id) {
        try {
            int n = workorderMapper.deleteByPrimaryKey(id);
            if (n == 1) {
                return true;
            } else {
                throw new MyException("删除工单失败");
            }
        } catch (MyException e) {
            throw e;
        } catch (Exception e) {
            throw new MyException("系统错误：" + e.getMessage());
        }
    }

    @Override
    public Page<Workorder> selectWorkorderByStuId(Integer sid, Page page) {
        try {
            // 获取全部数据的数量
            int count = workorderMapper.selectCountWorkorder(sid);
            // 计算总页码和开始位置（传来的page中有pageNo和pageSize）
            page.setTotalCount(count);
            // 分页获取某一页的数据集
            List<Workorder> workorderList = workorderMapper.selectWorkorderByStuId(sid, page.getStartRow(), page.getPageSize());
            // 设置在page中
            page.setRows(workorderList);
            return page;
        }catch (Exception e) {
            throw new MyException("系统错误：" + e.getMessage());
        }
    }
}
