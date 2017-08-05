package com.convergence;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.convergence.domain.UserDTO;
import com.convergence.service.UserService;

@Component
public class test {
	@Resource
	private UserService userService;
	@PostConstruct
	public void ins(){
		UserDTO selectByPrimaryKey = userService.selectByPrimaryKey(1);
		System.out.println(selectByPrimaryKey);
	}

}
