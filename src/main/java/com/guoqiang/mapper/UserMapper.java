package com.guoqiang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guoqiang.entity.MusicList;
import com.guoqiang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //登录用户
    User login(User user);
    //注册用户
    void register(User user);
    //注册用户前的检验
    User checkBeforeRegister(User user);
    //修改用户信息
    void changeUserInfo(User user);

    User findByUsername(User user);

    void addMusicListToUser(User user, MusicList musicList);
}
