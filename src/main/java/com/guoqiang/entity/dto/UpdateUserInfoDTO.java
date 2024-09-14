package com.guoqiang.entity.dto;

import com.guoqiang.entity.User;

public class UpdateUserInfoDTO {
    private User user;
    private String token;

    public UpdateUserInfoDTO() {
    }

    public UpdateUserInfoDTO(User user, String token) {
        this.user = user;
        this.token = token;
    }

    /**
     * 获取
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "UpdateUserInfoDTO{user = " + user + ", token = " + token + "}";
    }
}
