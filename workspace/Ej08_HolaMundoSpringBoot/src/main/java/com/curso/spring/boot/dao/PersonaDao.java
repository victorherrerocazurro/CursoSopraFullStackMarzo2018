package com.curso.spring.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.boot.entities.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {

	public List<Persona> findByNombre(String nombre);
	
	@Query("select p from Persona p where p.apellido = ?1")
	public List<Persona> buscarPorApellido(String apellido);
	
}
