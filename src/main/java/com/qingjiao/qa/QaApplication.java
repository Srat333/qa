package com.qingjiao.qa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
public class QaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaApplication.class, args);
	}

}
