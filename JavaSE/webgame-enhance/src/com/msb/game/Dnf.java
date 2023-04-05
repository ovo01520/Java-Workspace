package com.msb.game;

import java.util.Random;
import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2021/2/15-9:24
 * @Description: WebGameEnhance
 * @Version: 1.0
 */
public class Dnf {
    //这是main方法,程序的入口
    public static void main(String[] args) {
        System.out.println("你好啊，我叫克伦特");
        System.out.print("请告知勇士装备的等级：");
        // 创建Scannner对象
        Scanner sc = new Scanner(System.in);
        int lv = sc.nextInt();
        // 开始强化
        System.out.println("装备正在增幅中....");
        // 创建一个随机数
        Random r = new Random();
        // 接收等级
        int a = r.nextInt(100);
        switch (lv){
            case 3:
                if(a<90){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！+" + lv + "太极天地剑");
                }
                break;
            case 4:
                if(a<80){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！+" + --lv + "太极天地剑");
                }
                break;
            case 5:
                if(a<70){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！+" + --lv + "太极天地剑");
                }
                break;
            case 6:
                if(a<60){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！+" + --lv + "太极天地剑");
                }
                break;
            case 7:
                if(a<50){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！太极天地剑");
                }
                break;
            case 8:
                if(a<40){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！太极天地剑");
                }
                break;
            case 9:
                if(a<30){
                    // 成功
                    System.out.println("恭喜你，强化成功！+" + ++lv + "太极天地剑");
                }else{
                    // 失败
                    System.out.println("很遗憾，强化失败！太极天地剑");
                }
                break;
        }
    }
}



