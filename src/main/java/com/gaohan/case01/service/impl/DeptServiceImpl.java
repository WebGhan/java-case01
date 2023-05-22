package com.gaohan.case01.service.impl;

import com.gaohan.case01.aop.MyLog;
import com.gaohan.case01.mapper.DeptMapper;
import com.gaohan.case01.mapper.EmpMapper;
import com.gaohan.case01.pojo.Dept;
import com.gaohan.case01.pojo.DeptLog;
import com.gaohan.case01.service.DeptLogService;
import com.gaohan.case01.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @MyLog
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class) // spring 事物管理
    @Override
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id);

            // int i = 1 / 0;
            // if (true) {
            //     throw new Exception("出错了！");
            // }

            empMapper.unbindByDeptId(id); // 根据部门ID解绑员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDiscription("执行了解散部门的操作，此次解散的是" + id + "号部门");
            deptLogService.insert(deptLog);
        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {
        int i = 1/0;
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
