package com.gaohan.case01.controller;

import com.gaohan.case01.pojo.Dept;
import com.gaohan.case01.pojo.Result;
import com.gaohan.case01.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理 Controller
 */
@Slf4j
@RestController
// @RequestMapping("/depts")
public class DeptController {

    // private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门数据
     */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询部门:{}", id);

        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除部门:{}", id);

        // 调用service删除部门数据
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);

        // 调用service
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);

        // 调用service
        deptService.update(dept);
        return Result.success();
    }
}
