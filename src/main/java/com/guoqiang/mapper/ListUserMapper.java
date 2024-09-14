package com.guoqiang.mapper;

import com.guoqiang.entity.ListUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ListUserMapper {
    void addList(ListUser listUser);

    void remove(ListUser listUser);

    List<ListUser> select(ListUser listUser);
}
