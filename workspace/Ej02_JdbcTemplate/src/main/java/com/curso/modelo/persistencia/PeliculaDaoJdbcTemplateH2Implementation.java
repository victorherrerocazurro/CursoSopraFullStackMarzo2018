package com.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Pelicula;

@Repository
public class PeliculaDaoJdbcTemplateH2Implementation implements PeliculaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertar(Pelicula pelicula) {
		
		jdbcTemplate.update("INSERT INTO PELICULA (TITULO,DIRECTOR, GENERO, YEAR) VALUES(?,?,?,?)",
							pelicula.getTitulo(),
							pelicula.getDirector(),
							pelicula.getGenero(),
							pelicula.getYear());

	}
	
	@Override
	public void modificar(Pelicula pelicula) {
		
		jdbcTemplate.update("UPDATE INTO PELICULA (TITULO=?,DIRECTOR=?, GENERO=?, YEAR=?) VALUES WHERE ID=?",
							pelicula.getTitulo(),
							pelicula.getDirector(),
							pelicula.getGenero(),
							pelicula.getYear(),
							pelicula.getId());
		
	}
	
	@Override
	public void borrar(Pelicula pelicula) {
		
		jdbcTemplate.update("DELETE FROM PELICULA WHERE ID=?)",
							pelicula.getId());
		
	}
	
	@Override
	public Pelicula buscar(Integer id) {
		 return jdbcTemplate.queryForObject("SELECT * FROM PELICULA WHERE ID=?", new PeliculaRowMapper());
	}
	
	@Override
	public List<Pelicula> listarTodas(){
		return jdbcTemplate.query("SELECT * FROM PELICULA",new PeliculaRowMapper());
	}
	
}

class PeliculaRowMapper implements RowMapper<Pelicula>{
	@Override
	public Pelicula mapRow(ResultSet rs, int contador) throws SQLException{
		return new Pelicula(rs.getInt("ID"),
							rs.getString("TITULO"),
							rs.getString("DIRECTOR"),
							rs.getString("GENERO"),
							rs.getInt("YEAR"));
}
}