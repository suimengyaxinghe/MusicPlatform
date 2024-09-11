package com.guoqiang.service.impl;

import com.guoqiang.entity.User;
import com.guoqiang.mapper.UserMapper;
import com.guoqiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        User loginuser = userMapper.login(user);
        return loginuser;
    }

    public void register(User user){
        userMapper.register(user);
    }

    public User checkBeforeRegister(User user){
        User checkBeforeRegister = userMapper.checkBeforeRegister(user);
        return checkBeforeRegister;
    }

    @Override
    public void changeUserInfo(User user) {
        userMapper.changeUserInfo(user);
    }

    @Override
    public int findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
