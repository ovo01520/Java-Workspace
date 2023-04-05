package com.msb.pizza;

import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/16-13:45
 * @Description: 工厂类
 * @Version: 1.0
 */
public class PizzaStore {
    public static Pizza getPizza(int choice){
        Scanner sc = new Scanner(System.in);
        Pizza p = null;
        switch (choice){
            case 1:
            {
                System.out.print("请输入培根的克数：");
                int weight = sc.nextInt();
                System.out.print("请输入披萨的大小：");
                int size = sc.nextInt();
                System.out.print("请输入披萨的价格：");
                int price = sc.nextInt();
                //将录入的信息封装为培根披萨的对象
                BaconPizza bp = new BaconPizza("培根披萨",size,price,weight);
                p = bp;
            }
            break;
            case 2:
            {
                System.out.print("请输入您要加入的水果：");
                String burdening = sc.next();
                System.out.print("请输入披萨的大小：");
                int size = sc.nextInt();
                System.out.print("请输入披萨的价格：");
                int price = sc.nextInt();
                //将录入的信息封装为水果披萨的对象
                FruitsPizza fp = new FruitsPizza("水果披萨",size,price,burdening);
                p = fp;
            }
            break;
            case 3:
            {
                System.out.print("请输入牛肉的克数：");
                double beefweight = sc.nextDouble();
                System.out.print("请输入披萨的大小：");
                int size = sc.nextInt();
                System.out.print("请输入披萨的价格：");
                int price = sc.nextInt();
                //将录入的信息封装为牛肉披萨的对象
                beefPizza bp = new beefPizza("牛肉披萨",size,price,beefweight);
                p = bp;
            }
            break;
        }
        return p;
    }
}