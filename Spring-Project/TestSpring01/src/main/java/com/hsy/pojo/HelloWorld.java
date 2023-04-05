package com.hsy.pojo;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/4
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class HelloWorld {
    // 打招呼学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello(){
        return "sayHello:" + name;
    }
}
