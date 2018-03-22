package com.curso.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext contextoSpring = new AnnotationConfigWebApplicationContext();
		
		contextoSpring.setConfigLocation(this.getClass().getPackage().getName() + ".config");
		
		servletContext.addListener(new ContextLoaderListener(contextoSpring));
		
		//Hace lo mismo que la anotacion @webservlet
		/*Dynamic servlet = servletContext.addServlet("HolaMundoServlet", HolaMundoServlet.class);
		
		servlet.addMapping("/HolaMundo");*/
		
	}

}
