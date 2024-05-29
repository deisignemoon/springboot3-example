package com.xiacong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiacong.common.result.ResultVO;
import com.xiacong.mapper.BookMapper;
import com.xiacong.model.domain.Book;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BookController {

    @Resource
    private BookMapper mapper;

    @GetMapping(value = "/api/books/{pageNum}/{pageSize}", produces = "application/json")
    public ResultVO<PageInfo<Book>> findAll(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> all = mapper.findAll();
        PageInfo<Book> info = new PageInfo<>(all);
        return ResultVO.ok(info);
    }

    @GetMapping(value = "/api/books/{id}", produces = "application/json")
    public Book findById(@PathVariable Long id) {
        return mapper.findAllByIdBook(id);
    }
}