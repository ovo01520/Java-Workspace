package com.msb.redpacket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/2/3-10:56
 * @Description: RedPacketCalculate
 * @Version: 1.0
 */
public class RedPacket {
    //以元为单位
    public static int MIN_MONEY = 1;
    public static int MAX_MONEY = Integer.MAX_VALUE;
    //平均金额的倍数
    public static int TIMES = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要发放的红包金额：");
        int rMoney = sc.nextInt();
        System.out.print("请输入你要发放红包的数量：");
        int rCount = sc.nextInt();
        List<Integer> result = splitRedPacket(rMoney,rCount);
        System.out.println(result);
        int sum = 0;
        //itar快捷键
        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i);
        }
        System.out.println(sum + "元红包发放完毕！");
    }

    //红包分配算法 参数是金额和数量
    private static List<Integer> splitRedPacket(int money, int count) {
        //先校验参数的有效性
        if(!check(money,count)){
            System.out.println("您输入的金额无法分配，请重新输入!");
            return new ArrayList<>();
        }
        MAX_MONEY = money/count * TIMES;
        //声明一个容器 来盛装计算的结果
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            //计算出的最大值 还要和剩余金额比较，如剩下2分钱 而计算金额的最大值为4分钱 此时要以2分钱为标椎
            //将最大值和剩余金额中 更小的值取出 重新赋值给最大值
            MAX_MONEY = Math.min(money,MAX_MONEY);
            /*三元表达式
            MAX_MONEY = money>MAX_MONEY?MAX_MONEY:money;
            */
            int random = random(money,count-i,MIN_MONEY,MAX_MONEY);
            list.add(random);
            money -= random;
        }
        return list;
    }

    //随机的计算逻辑
    public static int random(int money,int count,int min,int max){
        //处理极端条件
        if(count == 1){
            return money;
        }
        if(min == max){
            return min;
        }
        //随机结果
        //random()方法 在[0,1)的范围内 随机出一个数
        //通过(max-min)*random + min来获取[min,max)之间的随机数
        double random = Math.random()*(MAX_MONEY - MIN_MONEY) + MIN_MONEY;
        //最接近double值的整数(四舍五入)
        int randomInt = (int)Math.rint(random);
        //校验剩余金额的有效性
        int retainMoney = money - randomInt;
        int retainCount = count - 1;
        if(check(retainMoney,retainCount)){
            return randomInt;
        }
        //校验不合理 重新随机
        /*
        不合理的两种情况
            1.小于最小值  之前随机的太大了(剩余不足)  修改最大金额
            2.大于最大值  之前随机的太小了(分配不完)  修改最小金额
        */
        double retainAvg = retainMoney / retainCount;
        if(retainAvg < MIN_MONEY){
            //用上一次随机的结果 作为新的最大值
            return random(money, count, min,randomInt);
        }else if(retainAvg > MAX_MONEY){
            //用上一次随机的结果 作为新的最小值
            return random(money,count,min,randomInt);
        }
        //不断缩小最大值和最小值的范围 使得能够随机出一个有效的结果
        return randomInt;
    }

    public static boolean check(int money,int count){
        //红包的平均值是否在最大值和最小值之间
        double avg = money / count;
        if(avg < MIN_MONEY || avg > MAX_MONEY){
            return false;
        }
        return true;
    }
}

