package com.example.springboottestone.web.dao;

import com.example.springboottestone.web.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
