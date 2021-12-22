package com.codeonce.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeonce.controller.utils.R;
import com.codeonce.pojo.Book;
import com.codeonce.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    // 查询所有
    @GetMapping
    public R getAll() {
        return new R(true, service.list());
    }

    // 添加
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        boolean flag = service.save(book);
        return new R(flag, flag ? "添加成功^_^!" : "添加失败-_-!");
    }

    // 根据ID更新
    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = service.updateById(book);
        return new R(flag, flag ? "更新成功^_^!" : "更新失败-_-!");
    }

    // 根据ID查询
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, service.getById(id));
    }

    // 根据ID删除
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(service.removeById(id));
    }

    // 分页功能
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        Page<Book> page = new Page<>(currentPage, pageSize);

        // 模糊查询
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(book.getType()), "type", book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()), "name", book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()), "description", book.getDescription());

        // 执行查询
        Page<Book> bookPage = service.page(page, wrapper);
        // 如果当前页面值大于总页面值 则重新执行查询操作 使用最大页码值作为当前页面值
        if (currentPage > bookPage.getPages()) {
            page = new Page<>(bookPage.getPages(), pageSize);
            bookPage = service.page(page, wrapper);
        }

        return new R(true, bookPage);
    }

}
