package com.convergence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.convergence.support.aop.RequestLimitAop;

/**
 * 开启aop 配合自定义注解 RequestLimitAop。
 * 
 * @author andreby
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.convergence.support.aop" })
public class AopConfig {
	@Bean
	public RequestLimitAop requestLimitAop() {
		return new RequestLimitAop();
	}
}
