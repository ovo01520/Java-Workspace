package com.hsy.pojo;

import java.util.Date;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class Item {
    //商品的ID
    private int itemid;
    //商品的名称
    private String name;
    //商品的价格
    private int price;
    //商品的详细信息
    private String detail;
    //商品的上架时间
    private Date createtime;

    public Item() {
    }

    public Item(int itemid, String name, int price, String detail, Date createtime) {
        this.itemid = itemid;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.createtime = createtime;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String toString(){
        return "商品ID:"+this.getItemid()+",商品名称:"+this.getName()+",商品价格:"+this.getPrice()+",商品详细信息:"+this.getDetail()+",商品上架时间:"+this.getCreatetime();
    }
}
