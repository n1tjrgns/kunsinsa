package com.fakesinsa.fakesinsaboot.service;

import com.fakesinsa.fakesinsaboot.mapper.UserMapper;
import com.fakesinsa.fakesinsaboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class UserService {

    @Autowired
    UserMapper userMapper;

    //로그인 시 회원정보를 가져올 메소드//
    public User getUserInfo(User user)  {
        System.out.println("getUserInfo의 user : "+user);
        return userMapper.getUserInfo(user);
    }

    //회원가입 데이터 insert
    public int setUserInfo(User user) {
        return userMapper.setUserInfo(user);
    }

}
