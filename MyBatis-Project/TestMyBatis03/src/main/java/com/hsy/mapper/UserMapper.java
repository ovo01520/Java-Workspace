package com.hsy.mapper;

import com.hsy.pojo.UserAndItem;
import com.hsy.pojo.UserAndOrder;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.mapper
 * @version: 1.0
 */
public interface UserMapper {
    /* 查询全部的用户并且关联查询用户所产生的订单 */
    List<UserAndOrder> selectAllUserAndOrder();
    /* 查询全部的用户并且关联查询改用的订单、订单详情以及购买的商品 */
    List<UserAndItem> selectAllUserAndItem();
}
