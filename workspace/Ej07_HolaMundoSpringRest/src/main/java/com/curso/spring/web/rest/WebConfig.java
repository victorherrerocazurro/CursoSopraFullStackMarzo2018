package com.curso.spring.web.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext contextoSpring = new AnnotationConfigWebApplicationContext();
		
		contextoSpring.setConfigLocation(this.getClass().getPackage().getName() + ".config");
		
		Dynamic servlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(contextoSpring));
		
		servlet.addMapping("/");
		
		servlet.setLoadOnStartup(1);
	}

}
