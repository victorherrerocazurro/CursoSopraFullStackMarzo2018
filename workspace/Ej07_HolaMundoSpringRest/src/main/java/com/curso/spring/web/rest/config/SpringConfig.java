package com.curso.spring.web.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScans({
	@ComponentScan("com.curso.spring.web.rest.controllers")
})
public class SpringConfig {
}
