package com.hsy.pojo;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date birthday;
    private String addr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    // 空构造器
    public User() {
    }

    // 有参构造器
    public User(int id, String name, Date birthday, String addr) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.addr = addr;
    }

    // 重写toString()方法
    @Override
    public String toString() {
        return "编号：" + this.getId() +"，姓名：" + this.getName() + "，生日：" + this.getBirthday() + "，地址：" + this.getAddr();
    }
}
