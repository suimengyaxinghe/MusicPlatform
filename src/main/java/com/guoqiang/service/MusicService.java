package com.guoqiang.service;

import com.guoqiang.entity.Music;

import java.util.List;

public interface MusicService {
     List<Music> findAll();
     Music findByMusicname(Music music);
     void addMusic(Music music);

     List<Music> findByTongue(Music music);
}
