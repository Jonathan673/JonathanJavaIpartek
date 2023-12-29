package com.inmobiliariaPruebaSpring.accesodatos;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;

@Component
public class DaoEstablecimientoJdbc implements DaoEstablecimiento{
	private static final String SQL_SELECT = "SELECT id, nombre, ubicacion, localidad, tipo_establecimiento, precio FROM establecimientos";
	
	
	
	private JdbcTemplate jdbc;

	private SimpleJdbcInsert insertarEstablecimiento;

	public DaoEstablecimientoJdbc(DataSource dataSource) {
		this.insertarEstablecimiento = new SimpleJdbcInsert(dataSource).withTableName("establecimientos")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public Iterable<Establecimiento> obtenerTodos() {
		return jdbc.query(SQL_SELECT, new BeanPropertyRowMapper<Establecimiento>(Establecimiento.class));
	}

	@Override
	public Establecimiento obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Establecimiento insertar(Establecimiento establecimiento) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(establecimiento);
		Number newId = insertarEstablecimiento.executeAndReturnKey(parameters);
		establecimiento.setId(newId.longValue());
		return establecimiento;
	}

	@Override
	public Establecimiento modificar(Establecimiento objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Establecimiento> obtenerPorLocalidad(String localidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
