package com.gaohan.case01.mapper;

import com.gaohan.case01.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 分页查询获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 采用 pagehepler 方式
     * @return
     */
    public List<Emp> page2(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    @Insert("insert into emp (username, name, gender, image, entrydate, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender}, #{image}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 更新员工
     * @param emp
     */
    @Update("update emp" +
            " set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime}" +
            " where id = #{id}")
    void update(Emp emp);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 根据用户名和密码查询用户
     * @param emp
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 员工解绑部门
     * @param deptId
     */
    @Update("update emp set dept_id = null where dept_id = #{deptId}")
    void unbindByDeptId(Integer deptId);
}
