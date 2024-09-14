package com.guoqiang.mapper;

import com.guoqiang.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicMapper {
     List<Music> findALL();

     Music findByMusicname(Music music);

     void addMusic(Music music);

     List<Music> findByTongue(Music music);

    void deleteMusic(Music music);
}
