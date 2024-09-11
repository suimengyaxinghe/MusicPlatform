package com.guoqiang.service.impl;

import com.guoqiang.entity.Music;
import com.guoqiang.mapper.MusicMapper;
import com.guoqiang.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<Music> findAll() {
        return musicMapper.findALL();
    }

    @Override
    public Music findByMusicname(Music music) {
        return musicMapper.findByMusicname(music);
    }

    public void addMusic(Music music) {
        musicMapper.addMusic(music);
    }

    @Override
    public List<Music> findByTongue(Music music) {
        return musicMapper.findByTongue(music);
    }
}
