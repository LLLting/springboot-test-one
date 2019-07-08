package com.example.springboottestone.web.mapper;

import com.example.springboottestone.web.pojo.CategoryMybatis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapperAno {
    @Select("select * from category_")
    List<CategoryMybatis> findAll();
}
