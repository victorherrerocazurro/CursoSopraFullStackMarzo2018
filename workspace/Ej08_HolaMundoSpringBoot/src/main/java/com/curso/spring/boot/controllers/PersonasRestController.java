package com.curso.spring.boot.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.boot.dao.PersonaDao;
import com.curso.spring.boot.entities.Persona;

@RestController
@RequestMapping("/Personas")
public class PersonasRestController {
	
	@Autowired
	private PersonaDao dao;

	//Consulta de todos los recurso 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> get() {
		List<Persona> resultadoDeInvocaionDeServicio = dao.findAll();
		
		
		return new ResponseEntity<List<Persona>>(resultadoDeInvocaionDeServicio, HttpStatus.OK);
	}

	//Consulta por Id
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> get(@PathVariable("id") long id) {
		return new ResponseEntity<Persona>(dao.findOne(id), HttpStatus.OK);
	}

	//Creacion de recurso con PK generada por el sistema
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> post(@RequestBody Persona persona) throws URISyntaxException {
		
		Persona insertado = dao.save(persona);
		
		HttpHeaders headers = new HttpHeaders();
		
		long resultadoDeInvocacionDeServicio = insertado.getId();
		
		headers.setLocation(new URI("http://localhost:8080/Ej07_HolaMundoSpringRest/Personas/" + resultadoDeInvocacionDeServicio));
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//Modificacion total de recurso o creacion de recurso con PK generada por el cliente
	@PutMapping(path = "/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> put(@PathVariable("id") long id, 
					@RequestBody Persona persona) {
		return null;
	}
	
	//Modificacion parcial de recurso
	@PatchMapping(path = "/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> patch(@PathVariable("id") long id, @RequestBody String nombre) {
		return null;
	}

	//Borrado de recurso
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		return null;
	}

}
