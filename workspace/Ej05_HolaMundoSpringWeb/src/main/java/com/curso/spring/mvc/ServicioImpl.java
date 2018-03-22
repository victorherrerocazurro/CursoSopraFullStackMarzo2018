package com.curso.spring.mvc;

import org.springframework.stereotype.Service;

@Service
public class ServicioImpl implements Servicio {

	@Override
	public String saludar(String string) {
		return "Hola " + string + "!!!!";
	}

}
