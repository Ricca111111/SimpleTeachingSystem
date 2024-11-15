package com.hrk.controller;

import com.hrk.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.*;
@Controller
public class stuController {
    @RequestMapping("/user/addInfo")
    @ResponseBody
    public Map stuInfoAdd(Student student){
        System.out.println(student);
        Map res = new HashMap();
        res.put("isOk",true);
        res.put("msg","学生信息添加成功！！！");
        return res;
    }
}
