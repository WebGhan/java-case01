package com.gaohan.case01.mapper;

import com.gaohan.case01.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据ID删除部门
     * @param id ID
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    /**
     * 根据ID查询部门
     * @param id
     */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
