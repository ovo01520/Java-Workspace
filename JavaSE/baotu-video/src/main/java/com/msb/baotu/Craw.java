package com.msb.baotu;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.InputStream;

/**
 * @Auther: lixiaolong
 * @Date: 2021/12/08-8:12
 * @Description: BaoTuPicture
 * @Version: 1.0
 */
public class Craw {
    //这是main方法，程序的入口
    public static void main(String[] args) throws Exception{
        getVideo(1);
    }

    public static void getVideo(int page) throws Exception{
        //1. 创建一个链接才能对网页进行请求url
        //http请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2. 发送请求 get post
        HttpGet httpGet = new HttpGet("https://ibaotu.com/shipin/7-0-0-0-0-" + page + ".html");
        //3. 网址响应 200 404 500
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //4. 获取响应结果
        HttpEntity httpEntity = httpResponse.getEntity();
        //5. 将响应结果变成字符串
        String content = EntityUtils.toString(httpEntity,"UTF-8");
        //6. 解析HTML
        Document document = Jsoup.parse(content);
        //7. 选择要爬取的内容
        Elements elements = document.select("div.media-list div.video-play video");
        //8. 获取src的值
        for(int i = 1;i < elements.size();i++){
            System.out.println("第" + i + "个视频下载完成！");
            Element element = elements.get(i);
            String attr = element.attr("src");
            //9. 将https拼接到资源url
            CloseableHttpResponse httpResponse2 = httpClient.execute(new HttpGet("https:" + attr));
            //获取响应实体
            HttpEntity httpEntity2 = httpResponse2.getEntity();
            //获取mp4内容，为流
            InputStream stream = httpEntity2.getContent();
            //将流转换为视频文件，保存在D:/video/目录下
            FileUtils.copyInputStreamToFile(stream,new File("D:/video/" + page + "_" + i + ".mp4"));
            //关闭流
            stream.close();
        }
    }
}


