package com.guoqiang.controller;

import com.guoqiang.entity.*;
import com.guoqiang.entity.dto.UpdateUserInfoDTO;
import com.guoqiang.service.ListUserService;
import com.guoqiang.service.MusicListService;
import com.guoqiang.service.UserService;
import com.guoqiang.utils.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ListUserService listUserService;

    private List<LoginUser> loginUserList = new ArrayList<>();

    //用户登录
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return userService.login(user);

//        //检验用户名密码是否正确
//        User loginUser = userService.login(user);
//        Map<String, Object> map;
//        if (loginUser != null) {
//            //如果正确，生成token返回
//            map = new HashMap<>();
//            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getUser_id()), null);
//            map.put("token", token);
////            loginUserList.add(JwtUtil.createLoginUser(user, token));
//
//        } else {
//            return new ResponseResult(300, "用户名或密码错误，登录失败", null);
//        }
//
//
//        return new ResponseResult(200, "登陆成功", map);
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

            String token = JwtUtil.createJWT(String.valueOf(user.getUser_id()), user.getUsername(), null);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            // 返回注册成功的响应
            return new ResponseResult(200, "注册成功", map);
        }
    }

    //修改用户信息
    @PostMapping("/change")
    public ResponseResult changeUserInfo(@RequestBody UpdateUserInfoDTO data) {
        for (LoginUser l: loginUserList) {
            if (l.getToken().equals(data.getToken()) && data.getUser().getUser_id().equals(l.getUser().getUser_id())){
                userService.changeUserInfo(data.getUser());
            }
        }
        return new ResponseResult(200, "信息更新成功", null);
    }

    //用户收藏歌单
    @PostMapping("/addList")
    public ResponseResult addList(@RequestBody ListUser listUser){
        listUserService.addList(listUser);
        return new ResponseResult<>(200,"您收藏歌单成功",null);
    }

    //用户取消收藏歌单
    @PostMapping("/remove")
    public ResponseResult remove(@RequestBody ListUser listUser){
        listUserService.remove(listUser);
        return new ResponseResult<>(200, "将歌曲移除歌单成功", null);
    }
    //查询用户拥有的歌单
    @GetMapping("/select")
    public ResponseResult select(@RequestBody ListUser listUser){
        List<ListUser> allLists = listUserService.getAllLists(listUser);
        return new ResponseResult(200,"查询成功","list_id = 1");
    }
}
