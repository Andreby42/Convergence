package com.convergence.hessian;

import org.springframework.stereotype.Service;

import com.caucho.hessian.HessianUnshared;

@Service("hessianSayHelloService")
@HessianUnshared
public class HessianSayHelloServiceImpl implements HessianSayHelloService {

	@Override
	public String sayHello(String name) {
		return name;
	}

}
