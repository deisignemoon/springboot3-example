package com.xiacong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiacong.model.domain.Book;
import com.xiacong.service.BookService;
import com.xiacong.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 您好
* @description 针对表【book】的数据库操作Service实现
* @createDate 2024-05-09 14:50:00
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




