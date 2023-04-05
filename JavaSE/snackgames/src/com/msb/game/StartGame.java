package com.msb.game;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/22-21:01
 * @Description: com.msb.game
 * @Version: 1.0
 */
public class StartGame {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        //设置窗体对象
        JFrame jFrame = new JFrame();
        //设置窗体标题
        jFrame.setTitle("贪吃蛇小游戏 by lixiaolong");
        //获取屏幕的宽度和高度
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        //设置窗体大小和位置
        jFrame.setBounds((width-800)/2,(height-800)/2,800,800);
        //退出并结束游戏
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板对象
        GamePanel gamePanel = new GamePanel();
        //添加面板对象到窗体中
        jFrame.add(gamePanel);
        //设置禁止调节窗口大小
        jFrame.setResizable(false);
        //设置窗体显示
        jFrame.setVisible(true);
    }
}
