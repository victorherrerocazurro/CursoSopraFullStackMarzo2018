package com.curso.modelo.negocio.aop;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import ch.qos.logback.classic.Logger;

public class LogAdvice implements MethodBeforeAdvice,AfterReturningAdvice{
	
	private Logger logger;
	
	@Override
	public void before(Method metodo, Object[] parametros, Object target) throws Throwable{
		System.out.printf("Llamar al metodo %s de la clase %s. %s\n", 
							metodo.getName(),
							target.getClass().getName(),
							LocalDate.now());
	}
	
	@Override
	public void afterReturning(Object retorno, Method metodo, Object[] parametros, Object target) throws Throwable{
		System.out.printf("Fin de la llamada al metodo %s de la clase %s. %s\n", 
				metodo.getName(),
				target.getClass().getName(),
				LocalDate.now());
		
	}

	
}
