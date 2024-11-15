package com.hrk.controller;

import com.hrk.biz.UserBiz;
import com.hrk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz biz;

    @RequestMapping("/register")//访问注册类
    @ResponseBody
    public Map<String, Object> register(User user, HttpSession session) {
        System.out.println("Registering user: " + user);
        user = biz.register(user);
        Map<String, Object> res = new HashMap<>();
        if (user != null) {
            session.setAttribute("login_user", user);
            res.put("isOk", true);
            res.put("msg", "注册成功");
        } else {
            res.put("isOk", false);
            res.put("msg", "注册失败，用户可能已存在");
        }
        return res;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map login(User user, HttpSession session) {
        user = biz.checkLogin(user);
        session.setAttribute("login_user", user);
        System.out.println("User stored in session: " + session.getAttribute("login_user"));
        System.out.println("Session ID after login: " + session.getId());
        Map map = new HashMap();
        map.put("isOk", true);
        map.put("user", user);
        map.put("msg", "登录成功");
        return map;
    }


        @RequestMapping("/logout")
        @ResponseBody
        public Map<String, Object> logout(HttpSession session) {
            System.out.println("Session ID before logout: " + session.getId());
            Map<String, Object> response = new HashMap<>();
            if (session != null) {
                System.out.println("Session ID before logout: " + session.getId());
                session.invalidate();
                System.out.println("Session invalidated.");
                response.put("isOk", true);
                response.put("msg", "退出成功");
            } else {
                response.put("isOk", false);
                response.put("msg", "没有找到会话");
            }
            return response;
        }

//        @PostMapping("/logout")
//        public Map<String, Object> logout(HttpSession session) {
//            Map<String, Object> response = new HashMap<>();
//            session.invalidate();
//            response.put("isOk", true);
//            response.put("msg", "退出登录成功");
//            return response;
//        }

    public void setBiz(UserBiz biz) {
        this.biz = biz;
    }
}
