package com.hrk.mapper;

import com.hrk.entity.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from t_emp")
    List<Emp> selectEmps();

    @Select("select * from t_emp where empid=#{id}")
    Emp selectEmpById(int id);

    @Insert("insert into t_emp values (null,#{empName},#{tel},#{age})")
    int insertEmp(Emp emp);

    @Delete("delete from t_emp where empid=#{id}")
    int deleteEmpById(int id);
}
