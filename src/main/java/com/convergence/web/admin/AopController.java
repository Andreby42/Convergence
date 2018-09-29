package com.convergence.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convergence.support.RequestLimit;

@RequestMapping("/aop")
@Controller
public class AopController {

	@RequestMapping(value = "/test")
	@RequestLimit(count = 2)
	@ResponseBody
	public String requestLimit(HttpServletRequest request) {
		return "test";
	}

}
