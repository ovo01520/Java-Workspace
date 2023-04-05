package com.msb.taobao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//购物车秒杀
/**
 * @Auther: lixiaolong
 * @Date: 2021/12/29-11:55
 * @Description: TaobaoShopping
 * @Version: 1.0
 */
public class TaoBao {
    //这是main方法，程序的入口
    public static void main(String[] args) throws ParseException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSSSSSSS");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        //设置秒杀时间
        Date date = sdf.parse("2022-2-16 21:43:00 000000000");
        //1. 打开浏览器
        WebDriver browser = new ChromeDriver();
        //2. 输入www.taobao.com，访问淘宝首页
        browser.get("https://www.taobao.com");
        Thread.sleep(3000);
        //3. 点击 亲，请登录
        browser.findElement(By.linkText("亲，请登录")).click();
        //4. 扫码登录
        System.out.println("请尽快扫码登录");
        Thread.sleep(10000);
        //5. 进入购物车界面
        browser.get("https://cart.taobao.com/cart.htm?");
        Thread.sleep(3000);
        //6. 购物车界面点"全选"按钮
        if (browser.findElement(By.id("J_SelectAll1")).isEnabled()){
            browser.findElement(By.id("J_SelectAll1")).click();
        }
        Thread.sleep(2000);
        while (true){
            //当前的时间
            Date now = new Date();
            System.out.println(now);
            //7. 判断秒杀时间是否到了
            if(now.after(date)){
                if(browser.findElement(By.linkText("结 算")).isEnabled()){
                    browser.findElement(By.linkText("结 算")).click();
                    System.out.println("结算成功--->准备提交订单");
                    break;
                }
            }
        }
        Thread.sleep(2000);
        while (true) {
            if (browser.findElement(By.linkText("提交订单")).isEnabled()) {
                browser.findElement(By.linkText("提交订单")).click();
                System.out.println("抢购成功--->请尽快付款");
                break;
            }
        }
    }
}


