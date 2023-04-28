package com.gaohan.case01.controller;

import com.gaohan.case01.pojo.PageBean;
import com.gaohan.case01.pojo.Result;
import com.gaohan.case01.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理 Controller
 */
@Slf4j
@RestController
public class EmpController<T> {

    @Autowired
    private EmpService empService;

    /**
     * 按分页查询员工数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询参数：{}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);

        // 调用 service
        PageBean pageBean = empService.page2(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除员工
     * @param ids
     * @return
     */
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除：{}", ids);

        // 调用 service
        empService.delete(ids);
        return Result.success();
    }

}
