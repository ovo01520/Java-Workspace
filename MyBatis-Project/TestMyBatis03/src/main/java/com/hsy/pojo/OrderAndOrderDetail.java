package com.hsy.pojo;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class OrderAndOrderDetail extends Order {
    //订单关联订单详情以及商品
    private List<OrderDetailAndItem> oais;

    public List<OrderDetailAndItem> getOais() {
        return oais;
    }

    public void setOais(List<OrderDetailAndItem> oais) {
        this.oais = oais;
    }
}
