package com.msb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/19
 * @Description: com.msb.controller
 * @version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String testA(){
        return "index.jsp";
    }
}
