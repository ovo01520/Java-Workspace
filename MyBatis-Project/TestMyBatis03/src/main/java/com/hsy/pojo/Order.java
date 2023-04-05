package com.hsy.pojo;

import java.util.Date;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class Order {
    //订单的ID
    private int orderid;
    //订单的编号
    private String t_number;
    //订单的创建时间
    private Date createtime;
    //订单的备注
    private String note;
    //用户的编号
    private int id;

    public Order() {
    }

    public Order(int orderid, String t_number, Date createtime, String note, int id) {
        this.orderid = orderid;
        this.t_number = t_number;
        this.createtime = createtime;
        this.note = note;
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getT_number() {
        return t_number;
    }

    public void setT_number(String t_number) {
        this.t_number = t_number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "订单ID:"+this.getOrderid()+"用户编号:"+this.getId()+",订单编号:"+this.getT_number()+",订单创建时间:"+this.getCreatetime()+",订单备注:"+this.getNote();
    }
}
