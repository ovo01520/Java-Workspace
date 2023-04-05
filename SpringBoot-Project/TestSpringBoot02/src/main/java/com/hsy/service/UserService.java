package com.hsy.service;

import com.hsy.mapper.UserMapper;
import com.hsy.pojo.User;
import com.hsy.pojo.UserLike;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.hsy.service
 * @version: 1.0
 */
public interface UserService {
    /* 根据用户的id查询用户的信息 */
    User selectUserById(int id);
    /* 根据用户的姓名模糊查询用户的信息 */
    List<User> selectUsersByName(String name);
    /* 插入用户信息 */
    void insertUserInfo(User user);
    /* 更新用户信息 */
    void updateUserInfo(User user);
    /* 删除用户信息 */
    void deleteUserInfo(int id);
    /* 按照用户的姓名模糊或者地址模糊查询用户的信息 */
    List<User> findUserByNameOrAddrLikeInfo(UserLike userLike);
    /* 按照用户的姓名模糊或者地址模糊查询用户的数量 */
    int findUserByCount(UserLike userLike);
    /* 按照多个ID查询用户的信息 */
    List<User> findUserByIdsInfo(UserLike userLike);
}
