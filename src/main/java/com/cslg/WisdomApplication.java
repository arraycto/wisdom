package com.cslg;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cslg.*.dao")
@SpringBootApplication
public class WisdomApplication {

	/**
	 * 初始化时区
	 */
	@PostConstruct
    void started() {
		//获取时区：
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = calendar.getTimeZone();
		//设置时区：
		calendar.setTimeZone(timeZone);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(WisdomApplication.class, args);
		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    springboot启动成功      ヾ(◍°∇°◍)ﾉﾞ");
	}

}