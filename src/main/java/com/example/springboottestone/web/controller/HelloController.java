package com.example.springboottestone.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m){
        Calendar c = Calendar.getInstance();
        int year =c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        long time = System.currentTimeMillis();
        String date = "现在是" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";
        m.addAttribute("now", date+time);
        return "hello";
    }
}
