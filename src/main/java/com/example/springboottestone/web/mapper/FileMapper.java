package com.example.springboottestone.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FileMapper {
	
	int save(String name);
	
	List findAll();

}
