package com.convergence;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.convergence.web.websocket.NettyServer;

@SpringBootApplication
@EnableCaching // 开启缓存
@EnableTransactionManagement
@MapperScan("com.convergence.dao")
// 扫描三大web组件
@ServletComponentScan
//@EnableDiscoveryClient
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
public class ConvergenceApplication {

	public static void main(String[] args) {
//		new SpringApplicationBuilder(ConvergenceApplication.class).run(args);
//        new SpringApplicationBuilder(ConvergenceApplication.class).web(true).run(args);
        try {
            SpringApplication.run(ConvergenceApplication.class, args);
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
