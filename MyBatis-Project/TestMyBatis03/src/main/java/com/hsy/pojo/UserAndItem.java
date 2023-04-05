package com.hsy.pojo;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class UserAndItem extends User {
    //查询用户关联的订单以及订单详情
    private List<OrderAndOrderDetail> oaos;

    public List<OrderAndOrderDetail> getOaos() {
        return oaos;
    }

    public void setOaos(List<OrderAndOrderDetail> oaos) {
        this.oaos = oaos;
    }
}
