package com.hsy.mapper;

import com.hsy.pojo.User;
import com.hsy.pojo.UserLike;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/21
 * @Description: com.hsy.mapper
 * @version: 1.0
 */
public interface UserMapper {
    /* 按照用户的姓名模糊或者地址模糊查询用户的信息 */
    List<User> findUsersByNameOrAddr(UserLike userLike);
    /* 按照用户的姓名模糊或者地址模糊查询用户的数量 */
    int findUsersByCount(UserLike userLike);
    /* 按照多个ID查询用户的信息 */
    List<User> findUserByIds(UserLike userLike);
}
