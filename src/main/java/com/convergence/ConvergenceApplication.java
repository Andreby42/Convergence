package com.convergence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.convergence.web.websocket.NettyServer;

@SpringBootApplication
@EnableCaching // 开启缓存
@EnableTransactionManagement
@MapperScan("com.convergence.dao")
// 扫描三大web组件
@ServletComponentScan
@EnableDiscoveryClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
public class ConvergenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvergenceApplication.class, args);
        try {
            new NettyServer().run(NettyServer.WEB_SOCKET_PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
