package com.guoqiang.controller;

import com.guoqiang.entity.ResponseResult;
import com.guoqiang.entity.User;
import com.guoqiang.service.UserService;
import com.guoqiang.utils.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        //检验用户名密码是否正确
        User loginUser = userService.login(user);
        Map<String, Object> map;
        if (loginUser != null) {
            //如果正确，生成token返回
            map = new HashMap<>();
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getId()), null);
            map.put("token", token);
        } else {
            return new ResponseResult(300, "用户名或密码错误，登录失败", null);
        }


        return new ResponseResult(200, "登陆成功", map);
    }

    //用户注册
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        // 输入注册用户名和密码前先校验是否已经存在于数据库
        User checkBeforeRegister = userService.checkBeforeRegister(user);
        if (checkBeforeRegister != null) {
            // 如果数据库中存在，则返回注册失败
            System.out.println("用户已存在: " + checkBeforeRegister);
            return new ResponseResult(300, "注册失败，用户名已存在", null);
        } else {
            // 如果数据库中不存在，则继续注册
            userService.register(user);

            String token = JwtUtil.createJWT(String.valueOf(user.getId()), user.getUsername(), null);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            // 返回注册成功的响应
            return new ResponseResult(200, "注册成功", map);
        }
    }

    //主界面
}
