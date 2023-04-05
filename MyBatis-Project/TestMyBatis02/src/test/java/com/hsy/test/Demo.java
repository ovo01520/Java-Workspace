package com.hsy.test;

import com.hsy.mapper.UserMapper;
import com.hsy.pojo.User;
import com.hsy.pojo.UserLike;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/21
 * @Description: com.hsy.test
 * @version: 1.0
 */
public class Demo {
    @Test
    public void findUsersByNameOrAddr() throws IOException {
        // 指定核心配置文件的名字
        String resource = "mybatis.xml";
        // 创建字节输入流对象：
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // mapper动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 创建UserLike对象
        UserLike userLike = new UserLike("%张%","%京%");
        // 执行模糊查询操作：
        List<User> users = mapper.findUsersByNameOrAddr(userLike);
        // 遍历：
        for (User user:users){
            System.out.println(user);
        }
        // 关闭会话
        sqlSession.close();
    }

    @Test
    public void findUsersByCount() throws IOException {
        // 指定核心配置文件的名字
        String resource = "mybatis.xml";
        // 创建字节输入流对象：
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // mapper动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 创建UserLike对象
        UserLike userLike = new UserLike();
        // 为userLike对象进行赋值操作
        userLike.setLikeAddr("%京%");
        // 执行模糊查询操作：
        int count = mapper.findUsersByCount(userLike);
        // 打印数量
        System.out.println(count);
        // 关闭会话
        sqlSession.close();
    }
    // 按照多个ID查询用户的信息
    @Test
    public void findUserByIds() throws IOException {
        // 指定核心配置文件的名字
        String resource = "mybatis.xml";
        // 创建字节输入流对象：
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // mapper动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 创建UserLike对象
        UserLike userLike = new UserLike();
        // 为userLike对象进行赋值操作
        List<Integer> list = Arrays.asList(1,3,4);
        userLike.setIds(list);
        List<User> user = mapper.findUserByIds(userLike);
        // 执行模糊查询操作：
        for (User users:user){
            System.out.println(users);
        }
        // 关闭会话
        sqlSession.close();
    }
}
