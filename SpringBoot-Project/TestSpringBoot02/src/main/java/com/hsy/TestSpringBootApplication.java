package com.hsy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.hsy
 * @version: 1.0
 */
@MapperScan("com.hsy.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class TestSpringBootApplication {
    // 这是main方法，程序的入口
    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class,args);
    }
}
