package com.guoqiang.service.impl;

import com.guoqiang.entity.MusicList;
import com.guoqiang.mapper.MusicListMapper;
import com.guoqiang.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicListServiceImpl implements MusicListService {
    @Autowired(required = false)
    private MusicListMapper musicListMapper;
    @Override
    public void addMusicList(MusicList musicList) {
        musicListMapper.addMusicList(musicList);
    }

    @Override
    public List<MusicList> findAll() {
        return musicListMapper.findAll();
    }

    @Override
    public MusicList findByListName(MusicList musicList) {
        return musicListMapper.findByListname(musicList);
    }

    @Override
    public void delete(MusicList musicList) {
        musicListMapper.delete(musicList);
    }

    @Override
    public void restore(MusicList musicList) {
        musicListMapper.restore(musicList);
    }

}
