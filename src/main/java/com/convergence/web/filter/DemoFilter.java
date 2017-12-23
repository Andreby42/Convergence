package com.convergence.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = "/*", filterName = "demoFilter")
public class DemoFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(DemoFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("demoFilter init ....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("demoFilter doFilterING ....");
		// do some thing;
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		log.info("demoFilter destroy ....");

	}

}
