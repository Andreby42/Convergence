package com.convergence.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 将http访问请求转为https的过滤器 http与https共存时
 * 
 * @author andreby
 *
 */
@Configuration
@WebFilter(urlPatterns = "/*", filterName = "http2HttpsFilter")
public class Http2HttpsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestURL = request.getRequestURL().toString();
		String protocol = requestURL.split("://")[0];
		if ("http".equals(protocol)) {
			// 将http请求uri替换为https,将http端口请求替换为https端口 8081端口被nexus占用 换8082
			requestURL = requestURL.replace("http", "https").replace("8080", "8082");
			response.sendRedirect(requestURL);
		}
		filterChain.doFilter(request, response);
	}

}
