package com.codeonce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeonce.mapper.BookMapper;
import com.codeonce.pojo.Book;
import com.codeonce.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}