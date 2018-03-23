import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.negocio.GestorEmpleados;

public class pruebasAutoproxy {
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("BeansAutoproxy.xml");
		GestorClientes gc = (GestorClientes) appCtx.getBean("gestorClientes");
		GestorEmpleados ge = (GestorEmpleados) appCtx.getBean("gestorEmpleados");
		
		Cliente c = new Cliente("Groucho");
		gc.insertar(c);
		gc.borrar(c);
		
		ge.insertar("Bender Bending Rodriguez");
		ge.borrar("Bender Bending Rodriguez");
	
	}

}
