package com.guoqiang.service;

import com.guoqiang.entity.MusicVideo;

import java.util.List;

public interface MusicVideoService {

    void addMusicVideo(MusicVideo musicVideo);

    void deleteMusicVideo(MusicVideo musicVideo);

    List<MusicVideo> findAll();

    MusicVideo findByMVName(MusicVideo musicVideo);
}
