package com.codeonce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeonce.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
