package com.convergence.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.convergence.web.filter.DemoFilter;

@WebListener
public class DemoListener implements ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger(DemoFilter.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("convergence start .....");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("convergence stop .....");
	}

}
