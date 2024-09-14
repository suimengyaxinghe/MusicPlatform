package com.guoqiang.service;

import com.guoqiang.entity.MusicList;
import com.guoqiang.entity.ResponseResult;
import com.guoqiang.entity.User;

public interface UserService {
     ResponseResult login(User user);

     void register(User user);

    User checkBeforeRegister(User user);

    void changeUserInfo(User user);

    User findByUsername(User user);

    void addMusicListToUser(User user, MusicList musicList);
}
