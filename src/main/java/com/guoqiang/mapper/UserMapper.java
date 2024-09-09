package com.guoqiang.mapper;

import com.guoqiang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {
    //登录用户
    User login(User user);
    //注册用户
    void register(User user);
    //注册用户前的检验
    User checkBeforeRegister(User user);
}
