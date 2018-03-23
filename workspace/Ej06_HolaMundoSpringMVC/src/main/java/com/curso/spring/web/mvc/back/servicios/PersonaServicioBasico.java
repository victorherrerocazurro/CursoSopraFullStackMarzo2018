package com.curso.spring.web.mvc.back.servicios;

import org.springframework.stereotype.Service;

import com.curso.spring.web.mvc.front.dtos.Persona;

@Service
public class PersonaServicioBasico implements PersonaServicio {

	@Override
	public long alta(Persona body) {

		System.out.println("ALTA: En el servicio");
		
		return 0;
	}

	@Override
	public void modificar(Persona body) {
		System.out.println("MODIFICACION: En el servicio");

	}

}
