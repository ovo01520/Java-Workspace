package com.msb.doublecolorball;

import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/15-20:36
 * @Description: 双色球彩票系统
 * @Version: 1.0
 */
public class DoubleColorBall {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        int[] balls = new int[7];
        int count = 0;
        boolean isBuy = false;
        while (true) {
            System.out.println("************欢迎进入双色球彩票系统************");
            System.out.println("1. 购买彩票");
            System.out.println("2. 查看开奖");
            System.out.println("3. 退出");
            Scanner sc = new Scanner(System.in);
            System.out.print("请选择你要完成的功能：");
            int choice = sc.nextInt();
            while (choice != 1 && choice !=2 && choice != 3){
                System.out.println("您的选择不在范围内，请重新选择！");
                System.out.print("请选择你要完成的功能：");
                int newChoice = sc.nextInt();
                choice = newChoice;
            }
            switch (choice) {
                case 1:
                    System.out.println("双色球系统>>>购买彩票");
                    System.out.print("您需要下多少注：");
                    count = sc.nextInt();
                    for (int i = 1; i <=7; i++) {
                        if (i != 7){
                            System.out.println("请选择6个红球，第" + i + "个红球为：红球在(1-33)之间");
                            int redBall = sc.nextInt();
                            while (redBall > 33 || redBall < 1){
                                System.out.println("您选择的号码不在(1-33)之间，请重新选择!");
                                System.out.print("请重新选择一个号码(1-33)之间：");
                                int newRedBall = sc.nextInt();
                                redBall = newRedBall;
                            }
                            balls[i-1] = redBall;
                        }else{
                            System.out.println("请选择1个蓝球，蓝球为：红球在(1-16)之间");
                            int blueBall = sc.nextInt();
                            while (blueBall > 16 || blueBall < 1){
                                System.out.println("您选择的号码不在(1-16)之间，请重新选择!");
                                System.out.print("请重新选择一个号码(1-16)之间：");
                                int newBlueBall = sc.nextInt();
                                blueBall = newBlueBall;
                            }
                            balls[6] = blueBall;
                        }
                    }
                    System.out.println("您一共买了【"+ count + "】注，一共花费【" + count*2 + "】元，所选号码为：");
                    for (int number:balls){
                        System.out.print(number + "\t");
                    }
                    System.out.println();
                    isBuy = true;
                    break;
                case 2:
                    if (isBuy){
                        System.out.println("双色球系统>>>查看开奖");
                        int[] luckyBall = getLuckyBall();
                        int level = getLevel(balls, luckyBall);
                        switch (level){
                            case 1:
                                System.out.println("恭喜您，中了一等奖,1注奖金500万元，您一共获得：" + 500*count + "万元");
                                break;
                            case 2:
                                System.out.println("恭喜您，中了二等奖,1注奖金100万元，您一共获得：" + 100*count + "万元");
                                break;
                            case 3:
                                System.out.println("恭喜您，中了三等奖,1注奖金30万元，您一共获得：" + 30*count + "万元");
                                break;
                            case 4:
                                System.out.println("恭喜您，中了四等奖,1注奖金5万元，您一共获得：" + 5*count + "万元");
                                break;
                            case 5:
                                System.out.println("恭喜您，中了五等奖,1注奖金2千元，您一共获得：" + 2*count + "千元");
                                break;
                            case 6:
                                System.out.println("恭喜您，中了六等奖,1注奖金5元，您一共获得：" + 5*count + "元");
                                break;
                            case 7:
                                System.out.println("很遗憾，您未中奖！");
                                break;
                        }
                    }else{
                        System.out.println("对不起，请先购买彩票！");
                    }
                    break;
                case 3:
                    System.out.println("双色球系统>>>退出");
                    return;
            }
        }
    }

    //定义一个方法，专门用来生成中奖号码
    public static int[] getLuckyBall(){
        int[] luckyBalls = new int[7];
        for (int i = 1; i <=7; i++) {
            if (i != 7){
                luckyBalls[i-1] = (int)(Math.random()*33) + 1;
            }else{
                luckyBalls[6] = (int)(Math.random()*16) + 1;
            }
        }
        return luckyBalls;
    }

    //定义一个方法，专门用来比对购买号码和中奖号码的
    public static int getLevel(int[] balls,int[] luckyBalls){
        int level;
        int redCount = 0;
        int blueCount = 0;
        for (int i = 0; i <=6; i++) {
            if (i != 6){
                for (int j = 0; j <=5; j++) {
                    if (balls[i] == luckyBalls[j]){
                        redCount++;
                    }
                }
            }else {
                if (balls[6] == luckyBalls[6]){
                    blueCount++;
                }
            }
        }
        System.out.println("红球有"+ redCount + "个相等");
        System.out.println("蓝球有"+ blueCount + "个相等");
        if (redCount == 6 && blueCount == 1){
            level = 1;
        }else if (redCount == 6){
            level = 2;
        }else if (redCount == 5 && blueCount == 1){
            level = 3;
        }else if (redCount == 5 || (redCount == 4 && blueCount == 1)){
            level = 4;
        }else if (redCount == 4 || (redCount == 3 && blueCount == 1)){
            level = 5;
        }else if (redCount == 3 || (redCount == 2 && blueCount == 1)) {
            level = 6;
        }
        else{
            level = 7;
        }
        return level;
    }
}