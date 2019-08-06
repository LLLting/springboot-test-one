package com.example.springboottestone.web.controller;

import com.example.springboottestone.web.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: liu.ting
 * 2019/7/19 13:55
 */
@Controller
public class FileAccess {

    @Autowired
    private FileMapper fileMapper;

    @Value("${filePath.name}")
    public String fileName;

    @RequestMapping("/create")
    public void createFile(String content){
        File file = new File(fileName+"test.properties");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = content.getBytes();
        try {
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/download")
    public String downloadFile(Model model){
        File dirFile = new File(fileName);
        String[] fileList = dirFile.list();
        for(int i = 0;i < fileList.length; i++){
            String string = fileList[i];
            File file = new File(dirFile.getPath(),string);
            String name = file.getName();
            if (file.isDirectory()) {
                //递归
                System.out.println("目录"+i);
            }else{
                System.out.println(name);
                fileMapper.save(name);
            }
        }
        List list = fileMapper.findAll();
        model.addAttribute("fileList"+list);
        return "file";
    }
}
