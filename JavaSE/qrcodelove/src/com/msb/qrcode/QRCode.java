package com.msb.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lixiaolong
 * @Date: 2021/12/30-15:06
 * @Description: QRCodeLove
 * @Version: 1.0
 */
public class QRCode {
    //这是main方法，程序的入口
    public static void main(String[] args) throws WriterException, IOException {
        //1.利用Zxing.jar里面提供的一个工具类来帮我生成码：
        //2，创建工具类的对象：---》m
        MultiFormatWriter m = new MultiFormatWriter();
        //3.利用m对象来创建二维码：--》动作---》方法：
        /*
        想要使用encode()需要传入5个参数：
        String var1, BarcodeFormat var2, int var3, int var4, Map<EncodeHintType, ?> var5
        String var1 ： 表白的内容
        BarcodeFormat var2 : 告知你想画一维码还是二维码
        int var3 ： 接收二维码的宽
        int var4 ：接收二维码的高
        Map<EncodeHintType, ?> var5 ：存放键值对
        二维码的其他信息：
         */
        //表白的内容
        String str = "come on的喂！A B C";
        //告知你想画一维码还是二维码:
        BarcodeFormat b = BarcodeFormat.QR_CODE; //二维码
        //定义二维码的宽，高：
        int width = 500;
        int height = 500;
        /*
        二维码的其他信息：
        (1)纠错能力 ：
        L low  7%
        M middle  15%
        Q quartered  25%
        H high 30%
        (2)设置编码
        (3)设置留白：
         */
        Map map = new HashMap();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        map.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        map.put(EncodeHintType.MARGIN,2);
        //调用方法，传入5个参数：
        BitMatrix encode = m.encode(str, b, width, height, map);//encode代表的是二维码的对象 --》内存
        //encode代表的是二维码的对象 --》内存 ---->转成图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //就是将二维码对象中的有效数据展示出来：
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x,y,encode.get(x,y)? Color.BLACK.getRGB():Color.WHITE.getRGB());
            }
        }
        //图片对象 ---> 在内存：--》写入硬盘：
        File file = new File("d:/logo.png");
        //将image对象以png后缀写入file中去：
        boolean flag = ImageIO.write(image, "png", file);
        //根据flag进行后续的判断：
        if (flag){
            System.out.println("二维码生成成功！");
        }else{
            System.out.println("二维码生成失败！");
        }
    }
}