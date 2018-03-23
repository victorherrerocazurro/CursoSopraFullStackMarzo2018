import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

public class PruebasBeans {
	 public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans2.xml");
		
		Cliente c1 = (Cliente) appCtx.getBean("cliente6");
		Cliente c2 = (Cliente) appCtx.getBean("cliente6");
		Cliente c3 = (Cliente) appCtx.getBean("cliente6");
		
		System.out.println(c1+","+c1.getNombre());
		System.out.println(c2+","+c2.getNombre());
		System.out.println(c3+","+c3.getNombre());
		
		
		Cliente c4 = (Cliente) appCtx.getBean("cliente7");
		Cliente c5 = (Cliente) appCtx.getBean("cliente7");
		Cliente c6 = (Cliente) appCtx.getBean("cliente7");
		
		System.out.println(c4+","+c1.getNombre());
		System.out.println(c5+","+c2.getNombre());
		System.out.println(c6+","+c3.getNombre());
		
	}
}
