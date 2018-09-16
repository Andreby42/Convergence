package com.convergence;

import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.convergence.web.websocket.NettyServer;

@SpringBootApplication
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
