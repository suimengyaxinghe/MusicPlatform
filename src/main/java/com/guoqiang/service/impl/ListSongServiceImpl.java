package com.guoqiang.service.impl;


import com.guoqiang.entity.ListSong;
import com.guoqiang.mapper.ListSongMapper;
import com.guoqiang.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMapper listSongMapper;

    @Override
    public List<ListSong> getAllSongs(ListSong listSong) {
        return listSongMapper.getAllSongs();
    }

    @Override
    public void addSong(ListSong listSong) {
        listSongMapper.addSong(listSong);
    }

    @Override
    public void remove(ListSong listSong) {
        listSongMapper.remove(listSong);
    }
}
