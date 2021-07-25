package com.example.demo.Interceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


public class Configurer extends WebMvcConfigurationSupport {
	public static Logger logger = Logger.getLogger(Configurer.class);
	@Autowired
	Interceptor inter;
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		logger.info("intercepter");
		registry.addInterceptor(inter);
	}

}