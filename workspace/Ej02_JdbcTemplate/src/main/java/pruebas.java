import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;

public class pruebas {
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans.xml");
		
		GestorPeliculas gp = (GestorPeliculas) appCtx.getBean("gestorPeliculas");
		Pelicula p1 = new Pelicula(null,"T1","D1","CF",1984);
		gp.insertar(p1);
		
		List<Pelicula> peliculas = gp.listarTodas();
		for(Pelicula p: peliculas) {
			System.out.println(p);
		}
	}
}
