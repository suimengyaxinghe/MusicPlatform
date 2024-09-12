package com.guoqiang.mapper;

import com.guoqiang.entity.MusicVideo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicVideoMapper {
    void addMusicVideo(MusicVideo musicVideo);

    void deleteMusicVideo(MusicVideo musicVideo);

    List<MusicVideo> findAll();

    MusicVideo findByMVName(MusicVideo musicVideo);
}
