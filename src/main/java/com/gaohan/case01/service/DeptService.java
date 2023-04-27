package com.gaohan.case01.service;

import com.gaohan.case01.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id 用于删除部门的ID
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据ID查询部门
     * @param id
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);
}
