package com.convergence;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.convergence.domain.AtomDTO;
import com.convergence.domain.UserDTO;
import com.convergence.service.AtomService;
import com.convergence.service.UserService;

@Component
public class test {
	@Resource
	private UserService userService;
	/*
	 * @Resource private MgAtomService mgAtomService;
	 */
	@Resource
	private AtomService atomService;

	public void ins() {
		UserDTO selectByPrimaryKey = userService.selectByPrimaryKey(1);
		System.out.println(selectByPrimaryKey);
	}

//	 @PostConstruct
	public void testMg() {
		AtomDTO atomDTO = atomService.selectByPrimaryKey(99);
		// mgAtomService.insert(atomDTO);
		// AtomDTO selectOne = mgAtomService.selectOne(99);
		System.out.println(JSON.toJSONString(atomDTO));
	}
}
