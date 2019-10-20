package com.fakesinsa.fakesinsaboot.mapper;

import com.fakesinsa.fakesinsaboot.model.User;

public interface UserMapper {


    User getUserInfo(User user);

    int setUserInfo(User user);
}
