package com.hrk.biz;

import com.hrk.entity.Course;
import com.hrk.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CourseBiz {

   @Autowired
    private CourseMapper mapper;

    public List<Course> getCourseList(){
        return mapper.selectCourses();
    }

    public Course getCourseById(Integer id){
        return mapper.selectCourseById(id);
    }

    public boolean addCourse(Course course){

        return mapper.insertCourse(course)>0;
    }

    public boolean removeCourse(Integer id){
        return mapper.deleteCourseById(id)>0;
    }

    public void setMapper(CourseMapper mapper) {
        this.mapper = mapper;
    }

    public boolean updateCourse(Course course) {
        return mapper.updateCourse(course) > 0;
    }

    public List<Course> searchCourses(String searchType, String keyword) {
        if ("id".equals(searchType)) {
            try {
                Integer id = Integer.parseInt(keyword);
                return Collections.singletonList(getCourseById(id));
            } catch (NumberFormatException e) {
                return Collections.emptyList();
            }
        } else {
            return mapper.searchCourses(searchType, keyword);
        }
    }
}

