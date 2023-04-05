package com.hsy.test;

import com.hsy.mapper.UserMapper;
import com.hsy.pojo.*;
import com.hsy.singleton.Singleton;
import com.hsy.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/27
 * @Description: 测试类
 * @version: 1.0
 */
public class Demo {
    // 查询订单的详细信息，同时关联查询产生该订单的用户信息
    @Test
    public void selectAllOrderAndUser() throws IOException {
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = Singleton.getInstance();
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // mapper动态代理
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        // 执行查询订单及用户的信息操作：
        List<OrderCustomer> octm = mapper.selectAllOrderAndCustomer();
        // 遍历集合:
        for (OrderCustomer oc:octm){
            // 打印订单信息：
            System.out.println("订单信息：");
            System.out.println(oc);
            User user = oc.getUser();
            // 打印产生该订单的用户：
            System.out.println("产生该订单的用户：");
            System.out.println(user);
            // 打印分隔符
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
        // 关闭会话
        sqlSession.close();
    }

    /* 查询全部的用户并且关联查询用户所产生的订单 */
    @Test
    public void selectAllUserAndOrder(){
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = Singleton.getInstance();
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // mapper动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询订单及用户的信息操作：
        List<UserAndOrder> uaos = mapper.selectAllUserAndOrder();
        // 遍历集合：
        for (UserAndOrder uao:uaos){
            // 打印用户信息：
            System.out.println("用户信息：");
            System.out.println(uao);
            // 获取每个用户的订单信息
            List<Order> orders = uao.getOrders();
            System.out.println("该用户的订单信息：");
            // 遍历集合：
            for (Order oder:orders){
                System.out.println(oder);
            }
            // 打印分隔符
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
        // 关闭会话
        sqlSession.close();
    }

    /* 查询全部的用户并且关联查询改用的订单、订单详情以及购买的商品 */
    @Test
    public void selectAllUserAndItem() {
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = Singleton.getInstance();
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // mapper动态代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 获取用户的信息操作：
        List<UserAndItem> uais = mapper.selectAllUserAndItem();
        // 遍历集合：
        for (UserAndItem uai:uais){
            System.out.println("用户信息：");
            System.out.println(uai);
            // 获取每一个用户产生的订单
            List<OrderAndOrderDetail> oaos = uai.getOaos();
            System.out.println("该用户产生的订单：");
            for (OrderAndOrderDetail oao:oaos){
                System.out.println(oao);
                //获取该订单的所有的详细信息
                List<OrderDetailAndItem> oais = oao.getOais();
                System.out.println("该订单的详细信息:");
                for(OrderDetailAndItem oai:oais){
                    System.out.println(oai);
                    //获取详细信息中的商品信息
                    Item item = oai.getItem();
                    System.out.println("该订单购买的商品是：");
                    System.out.println(item);
                }
                // 打印分隔符
                System.out.println("---------------------------------------------------------------------------------------------------");
            }
        }
        // 关闭会话
        sqlSession.close();
    }
}
