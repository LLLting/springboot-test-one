package com.example.springboottestone.web.controller;

import com.example.springboottestone.web.pojo.Category;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author liuting
 *
 */
@RestController
@Log4j2
public class HelloController {

	@Autowired
	@Qualifier("categoryRedisTemplate")
	private RedisTemplate<String, Category> rt;

	@RequestMapping("/hello")
	public String hello(Model m) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		long time = System.currentTimeMillis();
		String date = "现在是" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";
		m.addAttribute("now", date + time);
		return "hello";
	}

	@RequestMapping("/redis")
	public String rd(Model model) {
		List<Category> cs = new ArrayList<Category>(2);
		Category cat = new Category();
		cat.setId(1);
		cat.setName("name");
		cs.add(cat);
		cs.add(cat);

		model.addAttribute("cs", cs);

		log.debug("category==============>{}", cs.toString());
		return "listCategory";
	}
	
	@GetMapping(value = "/test1")
	public String test1(HttpServletRequest request,String var1) {
//		log.info("==================打印日志开始==============={}",var1);
		log.info("URL: "+ request.getRequestURL().toString());
//		log.info("==================打印日志结束==============={}",var1);
		return "test1";
	}
	
    @GetMapping(value = "/test2")
    public String test2(HttpServletRequest request, String var1, String var2) {
//        log.info("============打印日志开始============");
        log.info("URL: " + request.getRequestURL().toString());
//        log.info("============打印日志结束============");
        if (1<2)
            throw new IllegalArgumentException("exception");
        return "test2";
    }
}
