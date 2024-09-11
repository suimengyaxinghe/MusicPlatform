package com.guoqiang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private Integer id;
    private String musicname;
    private String singername;
    private String lyricist;
    private String composer;

    private String publishtime;
    private String tongue;
    private String musictime;
}
