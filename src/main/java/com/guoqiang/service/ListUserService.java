package com.guoqiang.service;

import com.guoqiang.entity.ListUser;

import java.util.List;

public interface ListUserService {

    void addList(ListUser listUser);

    void remove(ListUser listUser);

    List<ListUser> getAllLists(ListUser listUser);
}
