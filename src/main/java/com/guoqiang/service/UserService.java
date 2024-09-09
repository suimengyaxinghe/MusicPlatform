package com.guoqiang.service;

import com.guoqiang.entity.User;

public interface UserService {
    public User login(User user);

    public void register(User user);

    User checkBeforeRegister(User user);
}
