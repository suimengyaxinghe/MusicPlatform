package com.guoqiang.controller;

import com.guoqiang.entity.MusicList;
import com.guoqiang.entity.ResponseResult;
import com.guoqiang.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musiclist")
public class MusicListController {
    @Autowired(required = false)
    private MusicListService musicListService;

    //创建歌单
    @PostMapping("/addmusiclist")
    public ResponseResult addMusicList(@RequestBody MusicList musicList){
        musicListService.addMusicList(musicList);
        return new ResponseResult(200,"增加歌单成功",musicList);

    }

    //查询所有歌单
    @GetMapping("/findAll")
    public ResponseResult findAll(){
        List<MusicList> MusicLists = musicListService.findAll();
        return new ResponseResult(200,"查询成功",MusicLists);
    }

    //根据歌单名字查询歌单
    @GetMapping("/findbylistname")
    public ResponseResult findByListname(@RequestBody MusicList musicList){
        MusicList musiclist = musicListService.findByListName(musicList);
        if(musiclist ==null){
            return new ResponseResult<>(300,"查询失败",null);
        }
        return new ResponseResult(200,"查询成功",musiclist);
    }

    //根据用户名字查询所属歌单


    //删除歌单
    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody MusicList musicList){
        musicListService.delete(musicList);
        return new ResponseResult(200,"删除歌单成功",null);
    }

    //恢复歌单
    @PostMapping("/restore")
    public ResponseResult restore(@RequestBody MusicList musicList){
        musicListService.restore(musicList);
        return new ResponseResult(200,"恢复歌单成功",null);
    }
}
