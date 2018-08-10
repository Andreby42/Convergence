package com.convergence.config;

import org.springframework.context.annotation.Configuration;


/**
 * 
 * @doc:设置session失效时间
 * @author Andreby
 * @date 2017年8月4日 下午4:48:30
 */
@Configuration
public class SessionConfig {

    /**
     * 1.x版本设置session失效时间 2.x使用配置文件
     */
/*    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setSessionTimeout(6000);
            }
        };
    }*/
}
