package com.msb.student;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2021/12/13-15:27
 * @Description: StudentManagement
 * @Version: 1.0
 */
public class Main {
    //这是main方法,程序的入口
    public static void main(String[] args) throws Exception{
        //录入学生信息:
        System.out.println("****************欢迎使用学生成绩信息管理系统**********************");
        //键盘录入
        //拿来一个扫描器
        Scanner sc = new Scanner(System.in);
        //录入学生的姓名:
        System.out.println("请录入学生的姓名:");
        String name = sc.next();
        //录入学生的年龄:
        System.out.println("请录入学生的年龄:");
        int age = sc.nextInt();
        //录入学生的性别:
        System.out.println("请录入学生的性别:");
        String gender = sc.next();
        //录入学生的数学成绩:
        System.out.println("请录入学生的数学成绩:");
        double mathScore = sc.nextDouble();
        //录入学生的英语成绩:
        System.out.println("请录入学生的英语成绩:");
        double englishScore = sc.nextDouble();

        //创建学生类对象
        Student s = new Student();
        //给对象s进行赋值
        s.name = name;
        s.age = age;
        s.gender = gender;
        s.mathScore = mathScore;
        s.englishScore = englishScore;

        //有一个具体文件:
        File f = new File("d://demo.txt");
        //有一个输出流:
        FileWriter fw = new FileWriter(f,true);
        fw.write("学生姓名:" + s.name + ",年龄:" + s.age + ",性别:" + s.gender +
                ",数学成绩:" + s.mathScore + ",英语成绩:" + s.englishScore);
    }
}
