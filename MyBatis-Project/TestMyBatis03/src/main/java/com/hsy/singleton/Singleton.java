package com.hsy.singleton;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/27
 * @Description: 单例模式
 * @version: 1.0
 */
public class Singleton {
    private static final Singleton SINGLETON = new Singleton();
    private static SqlSessionFactory sqlSessionFactory;// SqlSessionFactory静态属性
    private static InputStream inputStream;// 输入字节流静态属性
    private Singleton(){
        try {
            // 指定MyBatis核心配置文件的文件名
            inputStream = Resources.getResourceAsStream("mybatis.xml");
            // 创建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 外界通过getInstance方法进行访问单例
    public static SqlSessionFactory getInstance(){
        return sqlSessionFactory;
    }
}
