package com.guoqiang.controller;

import com.guoqiang.entity.ListSong;
import com.guoqiang.entity.Music;
import com.guoqiang.entity.MusicList;
import com.guoqiang.entity.ResponseResult;
import com.guoqiang.service.ListSongService;
import com.guoqiang.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/musiclist")
public class MusicListController {
    @Autowired
    private MusicListService musicListService;
    @Autowired
    private ListSongService listSongService;

    //创建歌单
    @PostMapping("/addmusiclist")
    public ResponseResult addMusicList(@RequestBody MusicList musicList) {
        musicListService.addMusicList(musicList);
        return new ResponseResult(200, "增加歌单成功", musicList);

    }

    //查询所有歌单
    @GetMapping("/findAll")
    public ResponseResult findAllMusicList() {
        List<MusicList> musiclists = musicListService.findAll();
        return new ResponseResult(200, "查询所有歌单成功", musiclists);
    }

    //根据歌单名字查询歌单
    @GetMapping("/findbylistname")
    public ResponseResult findByListname(@RequestBody MusicList musicList) {
        MusicList musiclist = musicListService.findByListName(musicList);
        if (musiclist == null) {
            return new ResponseResult<>(300, "查询失败", null);
        }
        return new ResponseResult(200, "查询成功", musiclist);
    }


    //删除歌单
    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody MusicList musicList) {
        musicListService.delete(musicList);
        return new ResponseResult(200, "删除歌单成功", "is_deleted = 1");
    }

    //恢复歌单
    @PostMapping("/restore")
    public ResponseResult restore(@RequestBody MusicList musicList) {
        musicListService.restore(musicList);
        return new ResponseResult(200, "恢复歌单成功", "is_deleted = 0");
    }

    //查询歌单里面的歌
    @GetMapping("/select")
    public ResponseResult select(@RequestBody ListSong listSong){
        List<ListSong> allSongs = listSongService.getAllSongs(listSong);
        return new ResponseResult(200,"查询成功",allSongs);
    }

    //将一首歌添加到歌单里
    @PostMapping("/addSong")
    public ResponseResult addSong(@RequestBody ListSong listSong) {
        listSongService.addSong(listSong);

        return new ResponseResult<>(200, "将歌曲添加到歌单成功", null);

    }

    //将一首歌移除歌单
    @PostMapping("/remove")
    public ResponseResult remove(@RequestBody ListSong listSong){
        listSongService.remove(listSong);
        return new ResponseResult<>(200, "将歌曲移除歌单成功", null);
    }
}
