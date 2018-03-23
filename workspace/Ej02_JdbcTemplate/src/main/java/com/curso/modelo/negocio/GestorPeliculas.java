package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.PeliculaDAO;

//@Service
//Esto es equivalente a: <bean id="gestorPeliculas" class="com.curso.modelo.negocio.GestorPeliculas">

//@Service(value=""gp")
//Esto es equivalente a: <bean id="gp" class="com.curso.modelo.negocio.GestorPeliculas">

//Así que así daríamos de alta el objeto(como añadir un bean en el xml)
@Service
public class GestorPeliculas {

	//Con el autowired inyectamos lo que va después como añadiamos propiedad dentro del bean
	@Autowired
	private PeliculaDAO peliculaDao;

	public void insertar(Pelicula pelicula) {

		peliculaDao.insertar(pelicula);
	} 
	
	public List<Pelicula> listarTodas(){
		return peliculaDao.listarTodas();
	}

}
