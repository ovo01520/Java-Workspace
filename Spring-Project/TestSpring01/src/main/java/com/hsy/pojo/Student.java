package com.hsy.pojo;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/4
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class Student {
    // 学生的姓名
    private String name;
    // 学校的属性
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
