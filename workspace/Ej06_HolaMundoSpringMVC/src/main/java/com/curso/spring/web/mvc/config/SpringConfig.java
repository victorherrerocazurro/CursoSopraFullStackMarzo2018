package com.curso.spring.web.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.curso.spring.web.mvc.back.servicios.PersonaServicio;
import com.curso.spring.web.mvc.back.servicios.PersonaServicioBasico;

@Configuration
@EnableWebMvc

@ComponentScans({
	@ComponentScan("com.curso.spring.web.mvc.front.controllers"),
	@ComponentScan("com.curso.spring.web.mvc.back.servicios")
})
public class SpringConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
	}

	@Bean
	public ViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/jsps/", ".jsp");
	}
	
	/*@Bean
	public PersonaServicio personaServicio() {
		return new PersonaServicioBasico();
	}*/
	
}
