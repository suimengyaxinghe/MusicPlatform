package com.guoqiang.controller;


import com.guoqiang.entity.Music;
import com.guoqiang.entity.ResponseResult;
import com.guoqiang.service.MusicService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired(required = false)
    private MusicService musicService;

    //查询所有歌曲信息
    @GetMapping("/findAll")
    public ResponseResult  findAllMusic(){
        List<Music> musics = musicService.findAll();
        return new ResponseResult(200,"查询所有歌曲成功",musics);
    }
    //根据名字查询歌曲信息
    @GetMapping("/findbymusicname")
    public ResponseResult  findByMusicname(@RequestBody Music music){
        Music findmusic = musicService.findByMusicname(music);
        if(findmusic.getMusicname() ==null){
            return new ResponseResult<>(300,"查询失败",null);
        }
        return new ResponseResult(200,"查询歌曲成功",findmusic);
    }
    //根据歌曲类别查询歌曲信息
    @GetMapping("/findbytongue")
    public ResponseResult findbytongue(@RequestBody Music music){
        List<Music> findmusic = musicService.findByTongue(music);
        if(findmusic ==null){
            return new ResponseResult<>(300,"查询失败",null);
        }
        return new ResponseResult(200,"查询歌曲成功",findmusic);
    }


    //增加歌曲--------管理员
    @PostMapping("/addmusic")
    public ResponseResult addMusic(@RequestBody Music music){
        musicService.addMusic(music);
        return new ResponseResult(200,"增加歌曲成功",music);
    }

    @PostMapping("/deletemusic")
    public ResponseResult deleteMusic(@RequestBody Music music){
        musicService.deleteMusic(music);
        return new ResponseResult(200,"删除歌曲成功","is_deleted = 1");
    }
}
