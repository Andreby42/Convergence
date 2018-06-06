package com.convergence.hessian;

import org.springframework.stereotype.Service;

@Service("hessianSayHelloService")
public class HessianSayHelloServiceImpl implements HessianSayHelloService {

	@Override
	public String sayHello(String name) {
		return name;
	}

}
