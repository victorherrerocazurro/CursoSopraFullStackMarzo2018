package com.curso.spring.mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet(urlPatterns="/HolaMundo")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Servicio servicio ;
	
	@Override
	public void init() throws ServletException {
		
		WebApplicationContext applicationContext = WebApplicationContextUtils
														.getWebApplicationContext(getServletContext());
		
		servicio = applicationContext.getBean(Servicio.class);		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // Nunca escribir codigo aqui, hacerlo en los metodos init
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Necesite ejecutar el codigo de algun Bean de Spring
		
		String saludo = this.servicio.saludar("Victor");
		
		response.getWriter().append(saludo);
		
		request.getRequestDispatcher("/WEB-INF/jsps/index.jsp").forward(request, response);
	}
}
