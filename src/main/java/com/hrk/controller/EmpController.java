package com.hrk.controller;

import com.hrk.biz.EmpBiz;
import com.hrk.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
   @Autowired
    private EmpBiz biz;
    @RequestMapping("/list")
    public Map findAll(){
        List<Emp> list=biz.getEmpList();
        Map map=new HashMap();
        map.put("isOk",true);
        map.put("emps",list);
        map.put("msg","查询成功");
        return map;
    }
    @RequestMapping("/del")
    public Map del(int id){
        boolean isOk =biz.removeEmp(id);
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
    public Map add(Emp emp){
        boolean isOk =biz.addEmp(emp);
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

    public void setBiz(EmpBiz biz) {
        this.biz = biz;
    }

}
