package com.msb.test;

import com.msb.pojo.Girl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/18
 * @Description: com.msb.test
 * @version: 1.0
 */
public class Demo {
    @Test
    public void TestGirl(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Girl g = (Girl)context.getBean("girl");
        System.out.println("女孩" + g.getName() + "和男孩" + g.getBoyFriend().getName() + "在谈恋爱！");
    }
}
