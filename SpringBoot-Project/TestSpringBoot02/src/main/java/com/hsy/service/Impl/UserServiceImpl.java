package com.hsy.service.Impl;

import com.hsy.mapper.UserMapper;
import com.hsy.pojo.User;
import com.hsy.pojo.UserLike;
import com.hsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.hsy.service
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /* 根据用户的id查询用户的信息 */
    @Override
    public User selectUserById(int id) {
        return userMapper.findUserById(id);
    }

    /* 根据用户的姓名模糊查询用户的信息 */
    @Override
    public List<User> selectUsersByName(String name) {
        return userMapper.findUsersByName(name);
    }

    /* 插入用户信息 */
    @Override
    public void insertUserInfo(User user) {
        userMapper.insertUser(user);
    }

    /* 更新用户信息 */
    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUser(user);
    }

    /* 删除用户信息 */
    @Override
    public void deleteUserInfo(int id) {
        userMapper.deleteUser(id);
    }

    /* 按照用户的姓名模糊或者地址模糊查询用户的信息 */
    @Override
    public List<User> findUserByNameOrAddrLikeInfo(UserLike userLike) {
        return userMapper.findUserByNameOrAddrLike(userLike);
    }

    /* 按照用户的姓名模糊或者地址模糊查询用户的数量 */
    @Override
    public int findUserByCount(UserLike userLike) {
        return userMapper.findUserByCount(userLike);
    }

    /* 按照多个ID查询用户的信息 */
    @Override
    public List<User> findUserByIdsInfo(UserLike userLike) {
        return userMapper.findUserByIds(userLike);
    }
}
