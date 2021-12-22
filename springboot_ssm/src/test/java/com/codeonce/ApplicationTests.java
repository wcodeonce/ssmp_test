package com.codeonce;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeonce.mapper.BookMapper;
import com.codeonce.pojo.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookMapper mapper;

    @Test
    void selectList1() {
        // 查询条件
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("type", "计算机理论");

        List<Book> bookList = mapper.selectList(wrapper);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void selectList2() {
        // 查询条件
        Book selectBook = new Book();
        selectBook.setType("计算机理论");
        QueryWrapper<Book> wrapper = new QueryWrapper<>(selectBook);

        List<Book> bookList = mapper.selectList(wrapper);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void selectList3() {
        String type = "计算机理论";
        // String type = null;
        // 查询条件
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(Book::getType, type);
        wrapper.eq(Strings.isEmpty(type), Book::getType, type);

        List<Book> bookList = mapper.selectList(wrapper);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void selectById() {
        Book book = mapper.selectById(1);
        System.out.println(book);
    }

    @Test
    void insert() {
        Book book = new Book();
        book.setType("测试类型");
        book.setName("测试数据");
        book.setDescription("测试数据");

        int result = mapper.insert(book);
        System.out.println(result);
    }

    @Test
    void updateById() {
        Book book = new Book();
        book.setId(14);
        book.setType("测试类型123");
        book.setName("测试数据123");
        book.setDescription("测试数据321");

        int result = mapper.updateById(book);
        System.out.println(result);
    }

    @Test
    void deleteById() {
        int result = mapper.deleteById(14);
        System.out.println(result);
    }

    @Test
    void selectPage() {
        // 传入参数
        // 当前页数 页面数据数
        IPage<Book> page = new Page<>(2, 5);

        // 查询条件
        QueryWrapper<Book> wrapper = new QueryWrapper<>();

        IPage<Book> bookIPage = mapper.selectPage(page, wrapper);

        System.out.println("数据总条数: " + bookIPage.getTotal());
        System.out.println("数据总页数: " + bookIPage.getPages());
        System.out.println("当前页数: " + bookIPage.getCurrent());

        List<Book> bookList = bookIPage.getRecords();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }


}
