package com.hsy.mapper;

import com.hsy.pojo.User;
import java.util.List;

public interface UserMapper {
    // 根据用户的id查询用户的信息
    List findUserById(int id);
    // 根据用户姓名模糊查询用户信息
    List<User> findUserByName(String name);
    // 插入用户操作
    void insertUser(User user);
    // 更新用户操作
    void updateUser(User user);
    // 删除用户操作
    void deleteUser(int id);
}
