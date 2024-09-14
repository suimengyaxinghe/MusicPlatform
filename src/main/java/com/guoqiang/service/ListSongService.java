package com.guoqiang.service;

import com.guoqiang.entity.ListSong;

import java.util.List;

public interface ListSongService {
    List<ListSong> getAllSongs(ListSong listSong);

    void addSong(ListSong listSong);

    void remove(ListSong listSong);
}
