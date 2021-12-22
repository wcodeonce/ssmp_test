package com.codeonce;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeonce.pojo.Book;
import com.codeonce.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class ServiceTest {
    @Autowired
    private BookService service;

    @Test
    void getList() {
        List<Book> bookList = service.list(null);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void getAll() {
        Book book = service.getById(1);
        System.out.println(book);
    }

    @Test
    void insert() {
        Book book = new Book();
        book.setType("测试数据1");
        book.setName("测试数据223");
        book.setDescription("测试数据测试数据");
        boolean save = service.save(book);
        System.out.println(save);
    }

    @Test
    void updateById() {
        Book book = new Book();
        book.setId(43);
        book.setType("测试数据1");
        book.setName("测试数据223");
        book.setDescription("测试数据测试数据");
        boolean save = service.updateById(book);
        System.out.println(save);
    }

    @Test
    void insertScript() {
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setType("测试类型" + i);
            book.setName("测试数据" + i + i);
            book.setDescription("测试内容" + i * i);
            boolean save = service.save(book);
            System.out.println(save);
        }
    }

    @Test
    void delete() {
        boolean remove = service.removeById(16);
        System.out.println(remove);
    }

    @Test
    void deletes() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("type", "测试类型");
        boolean remove = service.remove(wrapper);
        System.out.println(remove);
    }

    @Test
    void getPage() {
        Page<Book> page = new Page<>(1, 5);
        Page<Book> bookPage = service.page(page);
        List<Book> bookList = bookPage.getRecords();
        for (Book book : bookList) {
            System.out.println(book);
        }

    }
}

