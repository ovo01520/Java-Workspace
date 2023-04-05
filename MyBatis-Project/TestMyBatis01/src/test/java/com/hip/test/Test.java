package com.hip.test;

import com.hip.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        // 导入MyBatis的核心配置文件
        String resource = "mybatis.xml";
        // 输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建一个数据库会话
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 打开数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行
        List list = sqlSession.selectList("a.b.selectAllBooks");
        // 遍历集合
        for (int i = 0; i <= list.size() - 1; i++) {
            // 强制转换
            Book b = (Book)list.get(i);
            System.out.println(b.getName() + "--" + b.getAuthor() + "---" + b.getPrice());
        }
    }
}
