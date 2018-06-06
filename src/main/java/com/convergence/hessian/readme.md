

### hessian与springBoot 集成使用
	* 服务端与客户端都加入hessian依赖
	* 服务端操作
		* 创建一个被调用的接口A以及一个该接口A的实现类，交给spring注册
		* 在springboot中使用configuration注解进行管理hessian服务注册到web容器，使用@Bean(name=“/xxx”) 即类名来暴露服务路径
	* 客户端操作
	 	* 在客服端中导入hessian服务接口A,可以用pom方式或者直接将该接口复制到客户端工程。在configuration类中使用configuration注解进行配置远程信息接口这里，在类中写死或者调用配置文件获得服务路径，
	 	* 注入服务接口到某个类中，方法中就可以调用hessian服务的方法了