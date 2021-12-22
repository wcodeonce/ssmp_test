package com.codeonce.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data  // Lombok
@TableName("tbl_book") // 指定数据库表名
public class Book {
    @TableId(type = IdType.AUTO) // 指定主键自增
    private Integer id;

    private String type;
    private String name;
    private String description;
}
