package com.hsy.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/4
 * @Description: com.hsy.pojo
 * @version: 1.0
 */
public class Demo {
    @Test
    public void sayHelloTest(){
        // 配置Spring核心配置文件的路径
        String resource = "applicationContext.xml";
        // 创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        // 获取Bean对象
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloworld");
        System.out.println(helloWorld.sayHello());
    }

    @Test
    public void stuTest(){
        // 配置Spring核心配置文件的路径
        String resource = "applicationContext.xml";
        // 创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        // 获取Bean对象
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void listTest(){
        // 配置Spring核心配置文件的路径
        String resource = "applicationContext.xml";
        // 创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        // 获取Bean对象
        Classes classes = (Classes) context.getBean("class");
        System.out.println(classes);
    }

    @Test
    public void setTest(){
        // 配置Spring核心配置文件的路径
        String resource = "applicationContext.xml";
        // 创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        // 获取Bean对象
        Classes1 classes1 = (Classes1) context.getBean("class1");
        System.out.println(classes1);
    }

    @Test
    public void mapTest(){
        // 配置Spring核心配置文件的路径
        String resource = "applicationContext.xml";
        // 创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        // 获取Bean对象
        Classes2 classes2 = (Classes2) context.getBean("class2");
        System.out.println(classes2);
    }
}

