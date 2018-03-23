package com.curso.spring.web.mvc.back.servicios;

import com.curso.spring.web.mvc.front.dtos.Persona;

public interface PersonaServicio {

	long alta(Persona body);

	void modificar(Persona body);

}
