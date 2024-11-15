package com.hrk.controller;

import com.hrk.biz.NotiBiz;
import com.hrk.entity.Noti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/noti")
public class NotiController {
    @Autowired
    private NotiBiz biz;
    @RequestMapping("/nlist")
    public Map findAll(){
        List<Noti> list=biz.getNotiList();
        Map map=new HashMap();
        map.put("isOk",true);
        map.put("notis",list);
        map.put("msg","课程信息查询成功");
        return map;
    }
    @RequestMapping("/ndel")
    public Map del(Integer id){
        boolean isOk =biz.removeNoti(id);
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
    @RequestMapping("/nadd")
    public Map add(Noti noti){
        boolean isOk =biz.addNoti(noti);
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
    @RequestMapping("/nget")
    public Map<String, Object> get(Integer id) {

        Noti noti = biz.getNotiById(id);

        Map<String, Object> map = new HashMap<>();
        if (noti != null) {
            map.put("isOk", true);
            map.put("noti", noti);
            map.put("msg", "查询成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "查询失败，学生ID不存在");
        }
        return map;
    }

    @RequestMapping("/nupdate")
    public Map<String, Object> updateNoti(@RequestBody Noti noti) {
        Map<String, Object> map = new HashMap<>();
        boolean result = biz.updateNoti(noti);
        if (result) {
            map.put("isOk", true);
            map.put("msg", "更新成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "更新失败");
        }
        return map;
    }



    @RequestMapping("/nsearch")
    public Map searchNotis(String searchType, String keyword) {
        List<Noti> notis = biz.searchNotis(searchType, keyword);
        Map<String, Object> map = new HashMap<>();
        if (!notis.isEmpty()) {
            map.put("isOk", true);
            map.put("notis", notis);
            map.put("msg", "查询成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "未找到符合条件的通知信息");
        }
        return map;
    }

}