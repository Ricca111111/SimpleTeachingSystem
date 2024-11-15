package com.hrk.controller;

import com.hrk.biz.CourseBiz;
import com.hrk.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseBiz biz;
    @RequestMapping("/clist")
    public Map findAll(){
        List<Course> list=biz.getCourseList();
        Map map=new HashMap();
        map.put("isOk",true);
        map.put("courses",list);
        map.put("msg","课程信息查询成功");
        return map;
    }
    @RequestMapping("/cdel")
    public Map del(Integer id){
        boolean isOk =biz.removeCourse(id);
        Map map = new HashMap();
        if(isOk){
            map.put("isOk",true);
            map.put("msg","删除成功");
        }else{
            map.put("isOk",false);
            map.put("msg","删除失败");
        }
        return map;
    }
    @RequestMapping("/cadd")
    public Map add(Course course){
        boolean isOk =biz.addCourse(course);
        Map map = new HashMap();
        if(isOk){
            map.put("isOk",true);
            map.put("msg","添加成功");
        }else{
            map.put("isOk",false);
            map.put("msg","添加失败");
        }
        return map;
    }
    @RequestMapping("/cget")
    public Map<String, Object> get(Integer id) {

        Course course = biz.getCourseById(id);

        Map<String, Object> map = new HashMap<>();
        if (course != null) {
            map.put("isOk", true);
            map.put("course", course);
            map.put("msg", "查询成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "查询失败，学生ID不存在");
        }
        return map;
    }

    @RequestMapping("/cupdate")
    public Map<String, Object> updateCourse(@RequestBody Course course) {
        Map<String, Object> map = new HashMap<>();
        boolean result = biz.updateCourse(course);
        if (result) {
            map.put("isOk", true);
            map.put("msg", "更新成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "更新失败");
        }
        return map;
    }



    @RequestMapping("/csearch")
    public Map searchCourses(String searchType, String keyword) {
        List<Course> courses = biz.searchCourses(searchType, keyword);
        Map<String, Object> map = new HashMap<>();
        if (!courses.isEmpty()) {
            map.put("isOk", true);
            map.put("courses", courses);
            map.put("msg", "查询成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "未找到符合条件的课程信息");
        }
        return map;
    }


}
