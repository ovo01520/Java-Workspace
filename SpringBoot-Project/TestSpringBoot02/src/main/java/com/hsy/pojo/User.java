package com.hsy.pojo;

import java.util.Date;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class User {
    private int id;
    private String name;
    private Date birthday;
    private String addr;

    public User() {
    }

    public User(int id, String name, Date birthday, String addr) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.addr = addr;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "编号:" + this.getId() + ",姓名:" + this.getName() + ",生日:" + this.getBirthday() + ",地址:" + this.getAddr();
    }
}
