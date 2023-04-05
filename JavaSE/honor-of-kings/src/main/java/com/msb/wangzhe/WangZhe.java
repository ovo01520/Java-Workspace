package com.msb.wangzhe;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * @Auther: lixiaolong
 * @Date: 2021/12/05-15:36
 * @Description: HonorOfKings
 * @Version: 1.0
 */
public class WangZhe {
    //这是main方法，程序的入口
    public static void main(String[] args) throws Exception {
        //要建立的链接 访问网站
        Connection connection = Jsoup.connect("https://pvp.qq.com/web201605/herolist.shtml");
        //敲回车 访问网址，获取到的是html文件
        Document htmlDoc = connection.get();
        //定位到图片的位置
        Element elementUL = htmlDoc.selectFirst("[class=herolist clearfix]");
        //获取样式下的所有li列表
        Elements lis = elementUL.select("li");
        //遍历li列表，因为每一个li都包含一张具体的图片
        for (Element elementLi : lis) {
            //获取元素，拿到a标签
            Element elementA = elementLi.selectFirst("a");
            //获取到待访问的链接
            String href = elementA.attr("href");
            //链接中的名字”阿轲“
            String heroName = elementA.text();
            //补全链接
            String netPath = "https://pvp.qq.com/web201605/" + href;
            //访问链接 点开
            Document newDocument = Jsoup.connect(netPath).get();
            //找到大图的位置，并找到标记符
            Element div = newDocument.selectFirst("[class=zk-con1 zk-con]");
            //找到style
            String divStyle = div.attr("style");
            //获取待爬取的图片
            String background = divStyle.substring(divStyle.indexOf("'") + 1, divStyle.lastIndexOf("'"));
            String newURL = "https:" + background;
            //请求网址
            URL url = new URL(newURL);
            //这个流就是我们的图片
            InputStream inputStream = url.openStream();
            FileOutputStream fileOutputStream = new FileOutputStream("D://img//" + heroName + ".jpg");
            //需要一个数组
            byte[] b = new byte[1024];
            //读取图片信息，存入数组中
            int count = inputStream.read(b);
            while(count != -1){
                fileOutputStream.write(b,0,count);
                //清空流管道
                fileOutputStream.flush();
                //再读取下一次
                count = inputStream.read(b);
            }
            fileOutputStream.close();
            inputStream.close();
        }
    }
}
