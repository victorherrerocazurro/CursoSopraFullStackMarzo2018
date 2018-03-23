package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDAO;

public class GestorClientes {

	private ClienteDAO clienteDao;
	
	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}



	public void insertar(Cliente client) {
		
		//LN-(Logica de negocio)
		//...
		System.out.println("Gestor cliente:insertar"+client);
		clienteDao.insertar(client);
	}
	
}
