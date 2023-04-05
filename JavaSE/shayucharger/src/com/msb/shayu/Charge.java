package com.msb.shayu;

import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/5/19-15:58
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class Charge {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        String details = "";
        double balance = 0;
        while (true) {
            System.out.println("***************欢迎使用小鲨鱼记账系统***************");
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退出");
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入你要选择的功能：");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4){
                System.out.print("您输入有误！请重新输入你要选择的功能：");
                int newChoice = sc.nextInt();
                choice = newChoice;
            }
            switch (choice) {
                case 1:
                    System.out.println("记账系统>>>收支明细");
                    if (details != ""){
                        String substring = details.substring(0, details.length() - 1);
                        System.out.println(substring);
                        System.out.println("账户总余额：" + balance + "元");
                    }else{
                        System.out.println("账户总余额：0元");
                    }
                    break;
                case 2:
                    System.out.println("记账系统>>>登记收入");
                    System.out.print("请输入收入金额：");
                    double income = sc.nextDouble();
                    System.out.print("请输入收入说明：");
                    String incomeDetail = sc.next();
                    balance += income;
                    details = details + "收入：" + income + "元" + "\t\t" + "收入说明：" + incomeDetail + "\t\t" + "账户余额：" + balance + "元" +"\n";
                    break;
                case 3:
                    System.out.println("记账系统>>>登记支出");
                    System.out.print("请输入支出金额：");
                    double expend = sc.nextDouble();
                    System.out.print("请输入支出说明：");
                    String expendDetail = sc.next();
                    balance -= expend;
                    details = details + "支出：" + expend + "元"  + "\t\t"+ "支出说明：" + expendDetail + "\t\t" + "账户余额：" + balance + "元" + "\n";
                    break;
                case 4:
                    System.out.println("记账系统>>>退出");
                    System.out.println("感谢您下次使用！");
                    return;
            }
        }
    }
}