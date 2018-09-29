package com.convergence.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.convergence.support.RequestLimitException;

@ControllerAdvice(basePackages = { "com.convergence.web" })
public class ExceptionController {
	@ExceptionHandler(value= {RequestLimitException.class})
	public String requestLimitException(Model model) {
		model.addAttribute("errorMsg", "请求过于频繁,超出限制!");
		return "error";
	}

}
