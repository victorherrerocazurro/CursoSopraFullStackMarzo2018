package com.curso.spring.web.mvc.front.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.spring.web.mvc.back.servicios.PersonaServicio;
import com.curso.spring.web.mvc.front.dtos.Persona;

@Controller
@RequestMapping("/Personas")
public class PersonasController {
	
	@Autowired
	private PersonaServicio personaServicio;

	@RequestMapping(method=RequestMethod.POST)
	public String post(
			@ModelAttribute Persona body, 
			@RequestHeader("Accept") String headerAccept, 
			@RequestParam("accion") String requestParamAccion,
			Map<String, Object> model) {
		
		//1-Recoger datos del cliente
		//No hace falta que hagamos nada, lo hace Spring
		
		System.out.println(body);
		
		//2- Invocar la capa de servicios, al metodo que corresponda segun lo que el cliente quiere hacer
		// Suele existir una relacion 1-1 entre metodos de control y metodos de servicio.
		if(requestParamAccion.equals("ALTA")) {
			//3-Recogiendo el feedback de la capa servicio
			long id = personaServicio.alta(body);
			//4-Hacer llegar a la vista el feedback del servicio
			model.put("id", id);
		} else if(requestParamAccion.equals("MODIFICACION")) {
			personaServicio.modificar(body);
		}
		
		//5-Seleccionar la vista mas adecuada para representar el feedback
		String view = "persona/detalle";
		
		return view;
	}
	
}
