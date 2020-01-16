package com.example.springboottestone.config.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

/**
*@author liuting
*2020年1月16日上午10:31:15
*/
@Aspect
@Component
@Log4j2
public class PrintLogAspect {
	
	@Pointcut("execution(public * com.example.springboottestone.web.controller.HelloController.test*(..))")
	public void addAdvice() {}
	
	@Before("addAdvice()")
	public void before(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		HttpServletRequest requests = (HttpServletRequest) args[0];
		log.info("====================打印日志开始==================");
		log.info("URL: {}",requests.getRequestURL().toString());
		log.info("====================打印日志结束==================");
	}

}
