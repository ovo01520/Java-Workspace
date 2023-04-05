package com.msb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: 李晓龙
 * @Date: 2023/4/2
 * @Description: com.msb.controller
 * @version: 1.0
 */
@Controller
public class MyController {
    @RequestMapping("/firstController")
    @ResponseBody
    public String firstController(){
        return "Hello SpringBoot...";
    }
}
