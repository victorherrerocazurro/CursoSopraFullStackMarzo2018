package com.curso.spring.web.mvc.front.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
//Filtro o condicion
@RequestMapping("/HolaMundo")
public class HolaMundoController {

	//GET /HolaMundo
	//GET /HolaMundo?nombre=Pepe&apellido=Fernandez
	@RequestMapping(method=RequestMethod.GET)
	public String get(
			Map<String,Object> model, 
			@RequestParam(required = false, name = "nombre") String name, 
			@RequestParam(required = false, name = "apellido") String surname) {
		
		model.put("clave", "Valor");
		
		return "index";
		
	}
	
	//GET /HolaMundo/1 o /Holamundo/12 o ...
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public View getById(@PathVariable("id") int id, Map<String,Object> model) {
		
		model.put("clave", "Valor");
		
		return new InternalResourceView("/WEB-INF/jsps/index.jsp");	
	}
	
	
	
	//POST /HolaMundo
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView post() {
		
		HashMap<String, Object> model = new HashMap<>();
		
		model.put("clave", "Valor");
		
		return new ModelAndView("index", model);
	}
	
}
