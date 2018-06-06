package com.convergence.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.convergence.hessian.HessianSayHelloService;
/**
 *  hessian服務端注冊服務到web 發佈服務
 * @author andreby
 *
 */
@Configuration
public class HessianConfig {
	@Resource
	private HessianSayHelloService hessianSayHelloService;
	
	/**
	 *  发布服务到spring容器中 其实就是发布服务到web容器中 了
	 * @return
	 */
	@Bean(name="/sayHelloService")
	public HessianServiceExporter hessianSayHelloService() {
		//可以看下这个类 HessianServiceExporter
		HessianServiceExporter exporter = new HessianServiceExporter();      
	    exporter.setService(hessianSayHelloService);   
	    exporter.setServiceInterface(HessianSayHelloService.class);   
	    return exporter;
	}
}
