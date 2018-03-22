package com.curso.spring.web.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.curso.spring.web.mvc.front.controllers")
public class SpringConfig {

	@Bean
	public ViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/jsps/", ".jsp");
	}
	
}
