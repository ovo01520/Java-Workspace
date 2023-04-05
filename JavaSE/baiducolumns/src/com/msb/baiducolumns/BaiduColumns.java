package com.msb.baiducolumns;

import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2021/12/28-9:09
 * @Description: BaiduColumnsAlgorithm
 * @Version: 1.0
 */
public class BaiduColumns {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        //需要两个参数:
        //当前页：
        Scanner current = new Scanner(System.in);
        System.out.print("请输入当前页码：");
        int currentPage = current.nextInt();
        //总页数：
        Scanner total = new Scanner(System.in);
        System.out.print("请输入总页码：");
        int totalPage = total.nextInt();
        //开始的页码：
        int begin = 1;
        //尾页：
        int end = 10;
        //如果总页码不足10页的时候，end数字一定不是10，而是有多少页显示多少页
        if(totalPage < 10){
            end = totalPage;
        }
        //页数大于10页的时候，首页、尾页不同
        if(totalPage > 10){
            begin = currentPage - 5;
            end = currentPage + 4;
            //首页不能小于0
            if(begin <= 0){
                begin = 1;
                end = 10;
            }
            //尾页不能大于最大页码：
            if(end > totalPage){
                end = totalPage;
                begin = end - 9;
            }
        }
        //显示上一页、下一页、显示标号：
        //如果当前是第一页，不用显示上一页，如果从第2页开始就显示上一页：
        if(currentPage > 1){
            System.out.print("<上一页");
        }
        for (int i = begin; i <= end ; i++) {
            //在当前页码上加*
            if(i == currentPage){
                System.out.print(i + "*\t");
            }else{
                System.out.print(i + "\t");
            }
        }
        //如果当前页码是最后一页的话，就没有必要显示下一页了
        if(currentPage < totalPage){
            System.out.print("下一页>");
        }
    }
}

