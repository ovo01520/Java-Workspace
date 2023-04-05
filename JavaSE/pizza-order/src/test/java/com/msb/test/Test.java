package com.msb.test;

import com.msb.pizza.Pizza;
import com.msb.pizza.PizzaStore;

import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/16-13:14
 * @Description: 测试类
 * @Version: 1.0
 */
public class Test {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你需要购买的披萨(1.培根披萨  2.水果披萨  3.牛肉披萨)");
        int choice = sc.nextInt();
        Pizza pizza = PizzaStore.getPizza(choice);
        System.out.println(pizza.showPizza());
    }
}