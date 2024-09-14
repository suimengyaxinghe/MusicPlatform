package com.guoqiang.mapper;

import com.guoqiang.entity.ListSong;
import com.guoqiang.service.ListSongService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ListSongMapper {
    List<ListSong> getAllSongs();

    void remove(ListSong listSong);

    void addSong(ListSong listSong);
}
