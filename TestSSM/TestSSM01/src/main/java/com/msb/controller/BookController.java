package com.msb.controller;

import com.msb.pojo.Book;
import com.msb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/25
 * @Description: com.msb.controller
 * @version: 1.0
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/findAllBooks",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectAll(){
        List list = bookService.selectAll();
        System.out.println("一共有几本书籍：" + list.size());
        // 定义一个字符串用来接收字符串
        String books = "";
        for (int i = 0; i < list.size(); i++) {
            Book book = (Book)list.get(i);
            books = books + book.getId();
            books = books + book.getName();
            books = books + book.getAuthor();
            books = books + book.getPrice();
        }
        return books;
    }
}
