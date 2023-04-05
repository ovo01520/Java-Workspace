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
public class Boy {
    @Value("23")
    private int age;
    @Value("小刚")
    private String name;

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

    public Boy() {
    }

    public Boy(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
