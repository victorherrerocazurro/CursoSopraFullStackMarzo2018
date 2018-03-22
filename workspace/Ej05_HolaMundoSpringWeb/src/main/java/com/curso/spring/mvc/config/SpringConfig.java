package com.curso.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.curso.spring.mvc.Servicio;
import com.curso.spring.mvc.ServicioImpl;

@Configuration
@ComponentScan("com.curso.spring.mvc")
public class SpringConfig {

	/*@Bean
	public Servicio servicio(){
		return new ServicioImpl();
	}*/
	
}
