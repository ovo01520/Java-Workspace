package com.msb.game;

import javax.swing.*;
import java.net.URL;

/**
 * @Auther: lixiaolong
 * @Date: 2022/3/22-20:49
 * @Description: com.msb.game
 * @Version: 1.0
 */
public class Images {
    //封装 body图片对象
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    //封装 down图片对象
    public static URL downURL = Images.class.getResource("/images/down.png");
    public static ImageIcon downImg = new ImageIcon(downURL);
    //封装 food图片对象
    public static URL foodURL = Images.class.getResource("/images/food.png");
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    //封装 header图片对象
    public static URL headerURL = Images.class.getResource("/images/header.png");
    public static ImageIcon headerImg = new ImageIcon(headerURL);
    //封装 left图片对象
    public static URL leftURL = Images.class.getResource("/images/left.png");
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    //封装 right图片对象
    public static URL rightURL = Images.class.getResource("/images/right.png");
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    //封装 up图片对象
    public static URL upURL = Images.class.getResource("/images/up.png");
    public static ImageIcon upImg = new ImageIcon(upURL);
}
