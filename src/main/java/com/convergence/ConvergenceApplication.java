package com.convergence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.convergence.dao")
@EnableCaching//开启缓存
public class ConvergenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvergenceApplication.class, args);
	}
}
