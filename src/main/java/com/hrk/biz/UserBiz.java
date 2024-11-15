package com.hrk.biz;

import com.hrk.entity.Stud;
import com.hrk.entity.User;
import com.hrk.mapper.StudMapper;
import com.hrk.mapper.UserMapper;
import com.hrk.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {
    @Autowired

    private UserMapper mapper;
    public boolean addUser(User user){

        return mapper.insertUser(user)>0;
    }

    public User checkLogin(User user){
        User dbUser = mapper.selectUserByTel(user.getTel());
        System.out.println("dbUser: " + dbUser);
        System.out.println("Tel: " + user.getTel());
        if(dbUser!=null&&dbUser.getLoginPwd().equals(user.getLoginPwd())){
            dbUser.setLoginPwd(null);
            return dbUser;
        }
        else{
            throw new MyException("登录失败，电话不存在或密码错误");
        }
    }
    public User register(User user) {
        if (mapper.selectUserByTel(user.getTel()) == null) {
            mapper.insertUser(user);
            return user;
        } else {
            return null; // 用户已存在
        }
    }
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
