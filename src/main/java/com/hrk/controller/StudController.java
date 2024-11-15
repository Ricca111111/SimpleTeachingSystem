package com.hrk.controller;

import com.hrk.biz.StudBiz;
import com.hrk.entity.Stud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stud")
public class StudController {
    @Autowired
    private StudBiz biz;
    @RequestMapping("/list")
    public Map findAll(){
        List<Stud> list=biz.getStudList();
        Map map=new HashMap();
        map.put("isOk",true);
        map.put("studs",list);
        map.put("msg","学生信息查询成功");
        return map;
    }
    @RequestMapping("/del")
    public Map del(Integer sequence){
        boolean isOk =biz.removeStud(sequence);
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
    @RequestMapping("/add")
    public Map add(Stud stud){
        boolean isOk =biz.addStud(stud);
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
    @RequestMapping("/get")
    public Map<String, Object> get(Integer sequence) {
        System.out.println(sequence + " // received sequence");
        Stud stud = biz.getStudBySequence(sequence);
        System.out.println(stud + " // found student");

        Map<String, Object> map = new HashMap<>();
        if (stud != null) {
            map.put("isOk", true);
            map.put("stud", stud);
            map.put("msg", "查询成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "查询失败，学生ID不存在");
        }
        return map;
    }

    @RequestMapping("/update")
    public Map<String, Object> updateStud(@RequestBody Stud stud) {
        Map<String, Object> map = new HashMap<>();
        boolean result = biz.updateStud(stud);
        if (result) {
            map.put("isOk", true);
            map.put("msg", "更新成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "更新失败");
        }
        return map;
    }
    @RequestMapping("/search")
    public Map searchStuds(String searchType, String keyword) {
        List<Stud> studs = biz.searchStuds(searchType, keyword);
        Map<String, Object> map = new HashMap<>();
        if (!studs.isEmpty()) {
            map.put("isOk", true);
            map.put("studs", studs);
            map.put("msg", "查询成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "未找到符合条件的学生信息");
        }
        return map;
    }
    public void setBiz(StudBiz biz) {
        this.biz = biz;
    }

}
