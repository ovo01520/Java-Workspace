package com.hsy.pojo;

import java.util.Date;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/28
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class User {
    //用户的编号
    private int id;
    //用户的姓名
    private String name;
    //用户的生日
    private Date birthday;
    //用户的性别
    private String sex;
    //用户的地址
    private String address;

    public User() {
    }

    public User(int id, String name, Date birthday, String sex, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return "用户编号:"+this.getId()+",用户姓名:"+this.getName()+",用户生日:"+this.getBirthday()+",用户性别:"+this.getSex()+",用户地址:"+this.getAddress();
    }
}
