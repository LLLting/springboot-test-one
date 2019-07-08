package com.example.springboottestone.web.mapper;

import com.example.springboottestone.web.pojo.CategoryMybatis;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
    List<CategoryMybatis> findAll();
}
