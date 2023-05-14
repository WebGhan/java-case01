package com.gaohan.case01.mapper;

import com.gaohan.case01.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log (create_time, discription) values (#{createTime}, #{discription})")
    public void insert(DeptLog deptLog);

}
