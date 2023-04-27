package com.gaohan.case01.service.impl;

import com.gaohan.case01.mapper.DeptMapper;
import com.gaohan.case01.pojo.Dept;
import com.gaohan.case01.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
