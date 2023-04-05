package com.hsy.mapper;

import com.hsy.pojo.OrderCustomer;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/27
 * @Description: com.hsy.mapper
 * @version: 1.0
 */
public interface OrderMapper {
    /* 查询订单的详细信息，同时关联查询产生该订单的用户信息 */
    List<OrderCustomer> selectAllOrderAndCustomer();
}
