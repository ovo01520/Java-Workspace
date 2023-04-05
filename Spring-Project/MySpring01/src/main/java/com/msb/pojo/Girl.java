package com.msb.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/18
 * @Description: com.msb.pojo
 * @version: 1.0
 */
@Component
public class Girl {
    @Value("21")
    private int age;
    @Value("莉莉")
    private String name;
    @Autowired
    private Boy boyFriend;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy getBoyFriend() {
        return boyFriend;
    }

    public void setBoyFriend(Boy boyFriend) {
        this.boyFriend = boyFriend;
    }

    public Girl() {
    }

    public Girl(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Girl(int age, String name, Boy boyFriend) {
        this.age = age;
        this.name = name;
        this.boyFriend = boyFriend;
    }
}
