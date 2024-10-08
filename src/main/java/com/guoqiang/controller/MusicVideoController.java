package com.guoqiang.controller;

import com.guoqiang.entity.MusicVideo;
import com.guoqiang.entity.ResponseResult;
import com.guoqiang.service.MusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/musicvideo")
public class MusicVideoController {
    @Autowired
    private MusicVideoService musicVideoService;

    //添加mv-----管理员
    @PostMapping("/addmusicvideo")
    public ResponseResult addMusicVideo(@RequestBody MusicVideo musicVideo){
        musicVideoService.addMusicVideo(musicVideo);
        return new ResponseResult<>(200,"添加mv成功",null);
    }

    //删除mv-----管理员
    @PostMapping("/deletemusicvideo")
    public ResponseResult deleteMusicVideo(@RequestBody MusicVideo musicVideo){
        musicVideoService.deleteMusicVideo(musicVideo);
        return new ResponseResult<>(200,"删除mv成功",null);
    }

    //查询所有mv
    @GetMapping("/findAll")
    public ResponseResult findAll(){
        List<MusicVideo> videos = musicVideoService.findAll();
        return new ResponseResult<>(200,"查询成功",videos);
    }

    //根据名字查询mv
    @GetMapping("/findbymvname")
    public ResponseResult findByMVName(@RequestBody MusicVideo musicVideo){
        MusicVideo Video = musicVideoService.findByMVName(musicVideo);
        if (Video == null){
            return new ResponseResult(300,"查询失败，该mv不存在",null);
        }
        return new ResponseResult<>(200,"查询成功",Video);
    }
}
