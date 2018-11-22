package com.convergence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.convergence.web.websocket.NettyServer;

//跳过flowable的springBoot验证
@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@EnableCaching // 开启缓存
@EnableTransactionManagement
@MapperScan("com.convergence.dao")
// 扫描三大web组件
@ServletComponentScan
// @EnableDiscoveryClient
// @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
public class ConvergenceApplication {

	public static void main(String[] args) {
		try {
			new SpringApplicationBuilder(ConvergenceApplication.class).run(args);
			// new
			// SpringApplicationBuilder(ConvergenceApplication.class).web(true).run(args);
			// SpringApplication.run(ConvergenceApplication.class, args);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			new NettyServer().run(NettyServer.WEB_SOCKET_PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
