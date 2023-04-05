package com.hsy.pojo;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class OrderDetail {
    //订单详情的ID
    private int detailid;
    //订单的ID
    private int orderid;
    //商品的ID
    private int itemid;
    //商品的数量
    private int item_num;

    public OrderDetail() {
    }

    public OrderDetail(int detailid, int orderid, int itemid, int item_num) {
        this.detailid = detailid;
        this.orderid = orderid;
        this.itemid = itemid;
        this.item_num = item_num;
    }

    public int getDetailid() {
        return detailid;
    }

    public void setDetailid(int detailid) {
        this.detailid = detailid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getItem_num() {
        return item_num;
    }

    public void setItem_num(int item_num) {
        this.item_num = item_num;
    }

    public String toString(){
        return "订单详情ID:"+this.getDetailid()+",订单ID:"+this.getOrderid()+",商品ID:"+this.getItemid()+",商品数量:"+this.getItem_num();
    }
}
