package com.hrk.mapper;

import com.hrk.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CourseMapper {
//    private Integer order;
//    private Integer courseCode;
//    private String  courseName;
//    private float  credit;
//    private String courseNumber;
//    private String teacher;
    @Select("select * from t_course")
    List<Course> selectCourses();

    @Select("select * from t_course where id=#{id}")
    Course selectCourseById(@Param("id") Integer id);

    @Insert("insert into t_course values (null,#{courseCode},#{courseName},#{credit},#{courseNumber},#{teacher},#{detail})")
    int insertCourse(Course course);

    @Delete("delete from t_course where id=#{id}")
    int deleteCourseById(int id);

    @Update("update t_course set courseCode=#{courseCode},courseName=#{courseName},credit=#{credit},courseNumber=#{courseNumber} ,teacher=#{teacher} ,detail=#{detail} where id=#{id}")
    int updateCourse(Course course);

    @Select("select * from t_course where ${searchType} like concat('%',#{keyword},'%')")
    List<Course> searchCourses(@Param("searchType") String searchType, @Param("keyword") String keyword);
}
