
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;
import com.curso.modelo.negocio.excepcion.DatosPeliculaException;

public class Pruebas {
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		GestorPeliculas gp = appCtx.getBean(GestorPeliculas.class);//Aquí estamos pidiendo el bean por tipo y no por nombre, por eso no hace falta hacerle el cast delante (esto funciona si solo tenemos uno)
		
		List<Pelicula> peliculas = new ArrayList<>();
		peliculas.add(new Pelicula(null,"T11","G1","D1",1983));
		peliculas.add(new Pelicula(null,"T21","G2","D2",1988));
		peliculas.add(new Pelicula(null,"T31","G3","D3",1985));
		peliculas.add(new Pelicula(null,null,"G4","D4",1987));
		
		try {
			gp.insertar(peliculas);
		} catch (DatosPeliculaException e) {
			System.out.println(e.getMessage());
		}
		
		/*List<Pelicula> listado = gp.listarTodas();
		for(Pelicula p:listado) {
			System.out.println(p);
		}*/
		//Esto es equivalente a lo siguiente: (como la funciones flecha en JS)
		gp.listarTodas().forEach(p -> System.out.println(p));
	}
}
