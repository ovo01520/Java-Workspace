package com.hsy.test;

import com.hsy.mapper.UserMapper;
import com.hsy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Demo {
    // 根据用户的id查询用户的信息
    @Test
    public void findUserById() throws IOException {
        // 指定核心配置文件的路径
        String resource = "mybatis.xml";
        // 获取加载配置文件的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 加载配置文件，创建工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂类获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 动态代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询操作
        List list = userMapper.findUserById(2);
        // 遍历集合：
        list.forEach((x) -> System.out.println(x));
        // 关闭会话
        sqlSession.close();
    }

    // 根据用户姓名模糊查询用户信息
    @Test
    public void findUserByName() throws IOException {
        // 指定核心配置文件的路径
        String resource = "mybatis.xml";
        // 获取加载配置文件的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 加载配置文件，创建工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂类获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 动态代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行模糊查询操作
        List<User> list = userMapper.findUserByName("%张%");
        // 遍历集合:
        for (User user : list){
            System.out.println(user);
        }
        // 关闭会话
        sqlSession.close();
    }

    // 插入用户操作
    @Test
    public void insertUser() throws IOException {
        // 指定核心配置文件的路径
        String resource = "mybatis.xml";
        // 获取加载配置文件的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 加载配置文件，创建工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂类获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 动态代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建一个User对象
        User user = new User(5, "赵六", new Date(), "齐齐哈尔");
        // 执行插入操作
        userMapper.insertUser(user);
        System.out.println("用户添加成功！");
        // 事务相关的操作：
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }

    // 更新用户操作
    @Test
    public void updateUser() throws IOException {
        // 指定核心配置文件的路径
        String resource = "mybatis.xml";
        // 获取加载配置文件的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 加载配置文件，创建工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂类获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 动态代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建一个User对象
        User user = new User(5, "关羽", new Date(), "天津");
        // 执行更新操作
        userMapper.updateUser(user);
        System.out.println("用户更新成功！");
        // 事务相关的操作：
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }

    // 删除用户操作
    @Test
    public void deleteUser() throws IOException {
        // 指定核心配置文件的路径
        String resource = "mybatis.xml";
        // 获取加载配置文件的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 加载配置文件，创建工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过工厂类获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 动态代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行删除操作
        userMapper.deleteUser(5);
        System.out.println("用户删除成功！");
        // 事务相关的操作：
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }
}