package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.excepcion.DatosPeliculaException;
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
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(List<Pelicula> peliculas) throws DatosPeliculaException{
		for(Pelicula p: peliculas) {
			insertar(p);
		}
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor= {DatosPeliculaException.class})
	public void insertar(Pelicula pelicula) throws DatosPeliculaException {
		System.out.print("Comprobando el titulo...");
		if(pelicula.getTitulo()==null) {
			System.out.print("MAL...");
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new DatosPeliculaException("el titulo es obligatorio");
		}
		System.out.print("OK...");			
		peliculaDao.insertar(pelicula);
	} 
	
	public List<Pelicula> listarTodas(){
		return peliculaDao.listarTodas();
	}

}
