package com.guoqiang.service.impl;

import com.guoqiang.entity.MusicVideo;
import com.guoqiang.mapper.MusicVideoMapper;
import com.guoqiang.service.MusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicVideoServiceImpl implements MusicVideoService {
    @Autowired(required = false)
    private MusicVideoMapper musicVideoMapper;
    @Override
    public void addMusicVideo(MusicVideo musicVideo) {
        musicVideoMapper.addMusicVideo(musicVideo);
    }

    @Override
    public void deleteMusicVideo(MusicVideo musicVideo) {
        musicVideoMapper.deleteMusicVideo(musicVideo);
    }

    @Override
    public List<MusicVideo> findAll() {
        return musicVideoMapper.findAll();
    }

    @Override
    public MusicVideo findByMVName(MusicVideo musicVideo) {
        return musicVideoMapper.findByMVName(musicVideo);
    }
}
