package com.curso.modelo.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.curso.modelo.entidad.Cliente;

public class ClienteDAO {
	
	private DataSource  dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	Connection cx=null;
	
	public void insertar(Cliente client) {
		
		try {
			cx = dataSource.getConnection();
			System.out.println("ClienteDao: insertar"+cx);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
