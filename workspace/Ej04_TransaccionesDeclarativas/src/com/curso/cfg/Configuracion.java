package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.curso.modelo.negocio, com.curso.modelo.persistencia"})
@EnableTransactionManagement
public class Configuracion {
	
	@Bean
	public DataSource dataSourceH2() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:file:c:/h2/bbdd");
		ds.setUsername("sa");
		ds.setPassword("");
		
		return ds;
	}
	
	@Bean
	@Qualifier("dataSourceH2")
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbct = new JdbcTemplate(dataSource);
		return jdbct;
	}
	
	@Bean
	@Autowired
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	
	
}
