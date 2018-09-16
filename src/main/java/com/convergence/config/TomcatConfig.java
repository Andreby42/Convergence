package com.convergence.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
    @Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setSecure(false);
		// 设置http8080端口 和 重定向到https的端口8082 8081端口被nexus占用 换8082
		// 这个8080端口为http端口 如果这里设置了http端口那么server.port是不是就不用设置了？
		connector.setPort(8080);
		// 这个8082端口为https端口 8081端口被nexus占用 换8082
		connector.setRedirectPort(8082);
		return connector;
	}

	/**
	 * 這是2.x的配置方法 1.x與2，x不一樣
	 * 
	 * @Bean
	 * @return
	 */
	@Bean
	public ServletWebServerFactory servletContainer() {
			// http与https共存时候，需要强转http为https时候用注释代码
		
		   TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		   tomcat.addAdditionalTomcatConnectors(httpConnector()); 
		   return tomcat;
		 //若不需要共存就去掉http2httpsFilter,同时注释以上代码使用下面的注释代码
/*		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
		*/
		

	}
}
