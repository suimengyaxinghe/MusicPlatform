package com.guoqiang.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
public class User implements Serializable {
    @TableId
    private String user_id;

    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String hobby;
}
