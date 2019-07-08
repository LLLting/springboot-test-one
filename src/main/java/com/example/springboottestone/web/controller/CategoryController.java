package com.example.springboottestone.web.controller;

import com.example.springboottestone.web.dao.CategoryDAO;
import com.example.springboottestone.web.mapper.CategoryMapper;
import com.example.springboottestone.web.mapper.CategoryMapperAno;
import com.example.springboottestone.web.pojo.Category;
import com.example.springboottestone.web.pojo.CategoryMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryMapperAno categoryMapperAno;

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception{
        List<Category> cs = categoryDAO.findAll();
        m.addAttribute("cs",cs);
        return "listCategory";
    }

    @RequestMapping("/listCategoryMybatisAno")
    public String listCategoryMybatisAno(Model m){
        List<CategoryMybatis> cs = categoryMapperAno.findAll();
        m.addAttribute("cs",cs);
        return "listCategory";
    }

    @RequestMapping("/listCategoryMybatis")
    public String listCategoryMybatis(Model m){

        List<CategoryMybatis> cs = categoryMapper.findAll();
        m.addAttribute("cs",cs);
        return "listCategory";
    }
}
