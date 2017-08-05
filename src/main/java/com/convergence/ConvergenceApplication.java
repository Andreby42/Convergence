package com.convergence;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
// @EnableCaching//开启缓存
@EnableTransactionManagement
@MapperScan("com.convergence.dao")
public class ConvergenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvergenceApplication.class, args);
	}
}
