package com.msb.ktv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2021/12/18-12:21
 * @Description: KTVMelody
 * @Version: 1.0
 */
public class KTVSongs {
    //这是main方法,程序的入口
    public static void main(String[] args) {
        //定义一个集合
        ArrayList list = new ArrayList();
        while (true){
            System.out.println("*******************欢迎来到光影KTV*******************");
            System.out.println("1. 点歌");
            System.out.println("2. 展示歌曲列表");
            System.out.println("3. 歌曲置顶");
            System.out.println("4. 歌曲前移一位");
            System.out.println("5. 退出");
            //用户和程序进行交互:键盘录入数据
            //拿来一个扫描器:
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入你想要执行的功能编号:");
            //扫描键盘上的数字:整数
            int choice = sc.nextInt();//录入数字以后要进行回车操作，回车以后数字被choice接收
            //对录入的choice进行过滤
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {//录入错误
                System.out.println("对不起，您录入的功能不存在，请重新录入！");
                choice = sc.nextInt();
            }
            //根据choice录入的数据进行后续选择----分支结构
            switch (choice) {
                case 1:
                    System.out.println("1. 点歌");
                    System.out.println("请录入你要点的歌曲：");
                    String musicName = sc.next();
                    //要将点的歌曲放入list中
                    list.add(musicName);
                    System.out.println("点歌成功！");
                    break;
                case 2:
                    System.out.println("2. 展示歌曲列表");
                    System.out.println(list);
                    break;
                case 3:
                    System.out.println("3. 歌曲置顶");
                    //录入你要置顶的歌曲
                    System.out.println("请录入你要置顶的歌曲：");
                    String topMusic = sc.next();
                    //先删除
                    list.remove(topMusic);
                    //再插入
                    list.add(0,topMusic);
                    System.out.println("歌曲置顶成功！");
                    break;

                case 4:
                    System.out.println("4. 歌曲前移一位");
                    //录入你要前移的歌曲
                    int index ;
                    System.out.println("请录入你要前移的歌曲：");
                    String headMusic = sc.next();
                    if(list.contains(headMusic) == true){
                        index = list.indexOf(headMusic);
                        list.remove(index);
                        list.add(index-1,headMusic);
                        System.out.println("歌曲前移成功！");
                    }
                    break;
                case 5:
                    System.out.println("5. 退出");
                    return;
            }
        }
    }
}

