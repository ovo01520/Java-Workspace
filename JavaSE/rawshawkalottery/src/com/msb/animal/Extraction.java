package com.msb.animal;

/**
 * @Auther: lixiaolong
 * @Date: 2022/1/20-21:51
 * @Description: RawShawkaLottery
 * @Version: 1.0
 */
public class Extraction{
    //这是main方法，程序的入口
    public static void main(String[] args){
        //定义一个animails数组 用于存放十二生肖
        String[] animails = {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
        //调用生肖卡抽奖方法
        chkAnimails(animails);
    }

    public static void chkAnimails(String[] animails){
        //定义一个1-12的随机数
        int rd = (int)(Math.random() * 12) + 1;
        //遍历animails数组，满足条件，则进行输出
        for(int i=0;i<12;i++){
            if(i+1 == rd){
                System.out.println("生肖开奖结果为：" + animails[i]);
            }
        }
    }
}
