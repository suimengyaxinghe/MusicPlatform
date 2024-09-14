package com.guoqiang.service.impl;

import com.guoqiang.entity.ListUser;
import com.guoqiang.mapper.ListUserMapper;
import com.guoqiang.service.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserServiceImpl implements ListUserService {
    @Autowired
    private ListUserMapper listUserMapper;

    @Override
    public void addList(ListUser listUser) {
        listUserMapper.addList(listUser);
    }

    @Override
    public void remove(ListUser listUser) {
        listUserMapper.remove(listUser);
    }

    @Override
    public List<ListUser> getAllLists(ListUser listUser) {
        return listUserMapper.select(listUser);
    }
}
