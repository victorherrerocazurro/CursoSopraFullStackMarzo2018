package com.curso.modelo.negocio.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CronometroAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable{
		
		Method metodo = mi.getMethod();//El método al que se está llamando
		mi.getArguments();//Los parámetros
		mi.getStaticPart();//El target
		
		long inicio = System.currentTimeMillis();
		
		Object retorno = mi.proceed();
		
		long fin = System.currentTimeMillis();
		System.out.println("Llamando al méodo"+ metodo.getName()+"procesada en"+(fin-inicio)+"milisegundos.");
		
		return retorno;
	}

}
