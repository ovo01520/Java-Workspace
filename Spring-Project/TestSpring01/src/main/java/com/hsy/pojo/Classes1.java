package com.hsy.pojo;

import java.util.Set;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/4
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class Classes1 {
    // 班级的名称
    private String name;
    // 学生类的集合
    private Set<Student1> stu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student1> getStu() {
        return stu;
    }

    public void setStu(Set<Student1> stu) {
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", stu=" + stu +
                '}';
    }
}
