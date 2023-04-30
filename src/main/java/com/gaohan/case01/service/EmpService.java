package com.gaohan.case01.service;

import com.gaohan.case01.pojo.Emp;
import com.gaohan.case01.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 按分页查询员工数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);

    /**
     * 采用 pagehepler 方式分页
     */
    PageBean page2(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void delete(List<Integer> ids);


    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);
}
