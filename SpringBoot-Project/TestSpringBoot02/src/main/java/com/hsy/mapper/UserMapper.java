package com.hsy.mapper;

import com.hsy.pojo.User;
import com.hsy.pojo.UserLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.hsy.mapper
 * @version: 1.0
 */
@Mapper
public interface UserMapper {
    /* 根据用户的id查询用户的信息 */
    User findUserById(int id);
    /* 根据用户的姓名模糊查询用户的信息 */
    List<User> findUsersByName(String name);
    /* 插入用户信息 */
    void insertUser(User user);
    /* 更新用户信息 */
    void updateUser(User user);
    /* 删除用户信息 */
    void deleteUser(int id);
    /* 按照用户的姓名模糊或者地址模糊查询用户的信息 */
    List<User> findUserByNameOrAddrLike(UserLike userLike);
    /* 按照用户的姓名模糊或者地址模糊查询用户的数量 */
    int findUserByCount(UserLike userLike);
    /* 按照多个ID查询用户的信息 */
    List<User> findUserByIds(UserLike userLike);
}
