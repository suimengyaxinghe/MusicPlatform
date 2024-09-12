package com.guoqiang.service;

import com.guoqiang.entity.MusicList;

import java.util.List;

public interface MusicListService {
    void addMusicList(MusicList musicList);

    List<MusicList> findAll();

    MusicList findByListName(MusicList musicList);

    void delete(MusicList musicList);

    void restore(MusicList musicList);
}
