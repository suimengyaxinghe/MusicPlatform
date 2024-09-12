package com.guoqiang.mapper;

import com.guoqiang.entity.MusicList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicListMapper {
    void addMusicList(MusicList musicList);

    List<MusicList> findAll();

    MusicList findByListname(MusicList musicList);

    void delete(MusicList musicList);

    void restore(MusicList musicList);
}
