package com.msb.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/22-21:31
 * @Description: com.msb.game
 * @Version: 1.0
 */
public class GamePanel extends JPanel {
    //定义蛇的长度
    int length;
    //定义两个数组
    //一个数组存放蛇的x坐标
    int[] snackX = new int[200];
    //一个数组存放蛇的y坐标
    int[] snackY = new int[200];
    //游戏只有两个状态：开始，暂停
    boolean isStart = false;
    //加入一个定时器：
    Timer timer;
    //定义蛇头的方向：
    String direction;
    //定义食物的x，y坐标
    int foodX;
    int foodY;
    //定义一个积分
    int score;
    //加入一个变量 判断小蛇的死亡状态
    boolean isDie = false;
    public void init(){
        //初始化蛇的长度
        length = 3;
        //初始化蛇头的坐标
        snackX[0] = 175;
        snackY[0] = 275;
        //初始化第一节身子的坐标
        snackX[1] = 150;
        snackY[1] = 275;
        //初始化第二节身子的坐标
        snackX[2] = 125;
        snackY[2] = 275;
        //初始化蛇头的方向：
        direction = "R";
        //初始化食物的坐标：
        foodX = 300;
        foodY = 200;
    }
    public GamePanel(){
        init();
        this.setFocusable(true);
        //设置监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);
                //监听空格键
                if (keyCode == KeyEvent.VK_SPACE){
                    if (isDie){
                        //全部恢复到初始状态
                        init();
                        score = 0;
                        isDie = false;
                    }else {
                        //小蛇没有死亡
                        isStart = !isStart;
                        repaint();
                    }
                }
                //监听向上键
                if (keyCode == KeyEvent.VK_UP){
                    direction = "U";
                }
                //监听向下键
                if (keyCode == KeyEvent.VK_DOWN){
                    direction = "D";
                }
                //监听向左键
                if (keyCode == KeyEvent.VK_LEFT){
                    direction = "L";
                }
                //监听向右键
                if (keyCode == KeyEvent.VK_RIGHT){
                    direction = "R";
                }
            }
        });
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && isDie == false){
                    //动蛇身子
                    for (int i = length-1; i > 0; i--) {
                        snackX[i] = snackX[i-1];
                        snackY[i] = snackY[i-1];
                    }
                    //动蛇头
                    if ("R".equals(direction)){
                        snackX[0] += 25;
                    }
                    if ("L".equals(direction)){
                        snackX[0] -= 25;
                    }
                    if ("U".equals(direction)){
                        snackY[0] -= 25;
                    }
                    if ("D".equals(direction)){
                        snackY[0] += 25;
                    }

                    //防止蛇头超出边界
                    if (snackX[0] > 750){
                        snackX[0] = 25;
                    }
                    if (snackX[0] < 25){
                        snackX[0] = 750;
                    }
                    if (snackY[0] < 100){
                        snackY[0] = 725;
                    }
                    if (snackY[0] > 725){
                        snackY[0] = 100;
                    }
                    //监听碰撞的动作
                    if (snackX[0] == foodX && snackY[0] == foodY){
                        //蛇长度增加1
                        length++;
                        //食物的位置变化
                        foodX = (int)((Math.random() * 30) + 1) * 25;
                        foodY = (new Random().nextInt(26) + 4) * 25;
                        //积分加10操作
                        score += 10;
                    }
                    //死亡判定
                    for (int i = 1; i < length; i++) {
                        if (snackX[0]==snackX[i]&&snackY[0]==snackY[i]){
                            //将死亡状态改为true
                            isDie = true;
                        }
                    }
                    repaint();
                }
            }
        });
        //启动定时器
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(254, 255, 225));
        Images.headerImg.paintIcon(this,g,0,0);
        g.setColor(new Color(232, 255, 250));
        g.fillRect(10,70,770,685);

        //画蛇的头部
        //判断
        if ("R".equals(direction)){
            Images.rightImg.paintIcon(this,g,snackX[0],snackY[0]);
        }
        if ("L".equals(direction)){
            Images.leftImg.paintIcon(this,g,snackX[0],snackY[0]);
        }
        if ("U".equals(direction)){
            Images.upImg.paintIcon(this,g,snackX[0],snackY[0]);
        }
        if ("D".equals(direction)){
            Images.downImg.paintIcon(this,g,snackX[0],snackY[0]);
        }
        //画蛇的身体
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this,g,snackX[i],snackY[i]);
        }

        //如果游戏暂停，界面中间应该有这一句提示语：
        if (isStart == false){
            //画一个文字
            g.setColor(new Color(255, 164, 231));
            //设置字体
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //开始画文字
            g.drawString("按空格键开始游戏！",250,330);
        }

        //画食物：
        Images.foodImg.paintIcon(this,g,foodX,foodY);
        //画积分
        g.setColor(new Color(248, 255, 255));
        //设置字体
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        //开始画文字
        g.drawString("积分" + score,660,40);
        if (isDie){
            //画一个文字
            g.setColor(new Color(255, 105, 109));
            //设置字体
            g.setFont(new Font("微软雅黑",Font.BOLD,30));
            //开始画文字
            g.drawString("游戏结束！请按空格键重新开始！",180,330);
        }
    }
}
