package com.msb.service.Impl;

import com.msb.mapper.BookMapper;
import com.msb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/25
 * @Description: com.msb.service.Impl
 * @version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List selectAll() {
        return bookMapper.selectAllBook();
    }
}
