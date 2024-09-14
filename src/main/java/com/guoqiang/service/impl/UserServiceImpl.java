package com.guoqiang.service.impl;

import com.guoqiang.entity.LoginUser;
import com.guoqiang.entity.MusicList;
import com.guoqiang.entity.ResponseResult;
import com.guoqiang.entity.User;
import com.guoqiang.mapper.UserMapper;
import com.guoqiang.service.UserService;
import com.guoqiang.utils.JwtUtil;
import com.guoqiang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;
    @Autowired(required = false)
    private LoginUser loginUser;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUser_id();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
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
    public User findByUsername(User user) {
        return userMapper.findByUsername(user);
    }

    @Override
    public void addMusicListToUser(User user, MusicList musicList) {
        userMapper.addMusicListToUser(user,musicList);
    }
}
