package com.guoqiang.entity;

//public class LoginUser implements {
//    private User user;
//    private String token;
//
//    public LoginUser() {
//    }
//
//    public LoginUser(User user, String token) {
//        this.user = user;
//        this.token = token;
//    }
//
//    /**
//     * 获取
//     * @return user
//     */
//    public User getUser() {
//        return user;
//    }
//
//    /**
//     * 设置
//     * @param user
//     */
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    /**
//     * 获取
//     * @return token
//     */
//    public String getToken() {
//        return token;
//    }
//
//    /**
//     * 设置
//     * @param token
//     */
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String toString() {
//        return "LoginUser{user = " + user + ", token = " + token + "}";
//    }

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}