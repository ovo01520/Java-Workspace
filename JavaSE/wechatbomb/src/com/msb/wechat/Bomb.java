package com.msb.wechat;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * @Auther: lixiaolong
 * @Date: 2022/2/19-20:59
 * @Description: WeChatBomb
 * @Version: 1.0
 */
public class Bomb {
    //这是一个main方法，程序的入口
    public static void main(String[] args) throws AWTException, InterruptedException {
        //1.创建发送的内容
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要轰炸的内容：");
        String str = sc.next();
        //延时2000ms 然后进行轰炸
        Thread.sleep(2000);
        //2.内容保存到剪切板：Ctrl + C
        Clipboard s = Toolkit.getDefaultToolkit().getSystemClipboard();
        s.setContents(new StringSelection(str),null);
        //3.创建机器人对象：Ctrl + V
        Robot robot = new Robot();
        //4.重复发送轰炸
        for (int i = 0; i < 10; i++) {
            //按下 Ctrl + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            //松开
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            //Enter 回车 发送 按下和松开
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            //延时 500ms
            robot.delay(500);
        }
    }
}
