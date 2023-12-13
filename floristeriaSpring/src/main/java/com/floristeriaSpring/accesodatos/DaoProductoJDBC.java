package com.floristeriaSpring.accesodatos;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.floristeriaSpring.entidades.Producto;

@Component
public class DaoProductoJDBC implements DaoProducto{

	private static final String SQL_SELECT = "SELECT id, nombre, tipo_producto, precio, unidades FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + "WHERE id=?";
//	private static final String SQL_INSERT = "INSERT INTO(productos nombre, tipo_producto, precio, unidades) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, tipo_producto=?, precio=?, unidades=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private SimpleJdbcInsert insertar;

	public DaoProductoJDBC(DataSource dataSource) {
		this.insertar = new SimpleJdbcInsert(dataSource)
				.withTableName("productos")
				.usingGeneratedKeyColumns("id");
	}
	
	@Override
	public Producto insertar(Producto producto) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(producto);
		Number newId = insertar.executeAndReturnKey(parameters);
		producto.setId(newId.longValue());
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		jdbc.update(SQL_UPDATE, producto.getNombre(),producto.getProductTipe(),producto.getPrecio(),producto.getUnidades(),producto.getId());
		return producto;
	}

	@Override
	public void eliminar(Long id) {
		jdbc.update(SQL_DELETE,id);
	}

	@Override
	public Iterable<Producto> listarTodos() {
		return jdbc.query(SQL_SELECT, new BeanPropertyRowMapper<Producto>(Producto.class));
	}

	@Override
	public Producto listarPorId(Long id) {
		return jdbc.queryForObject(SQL_SELECT_ID, new BeanPropertyRowMapper<Producto>(Producto.class), id);
	}

	@Override
	public Iterable<Producto> obtenerPorNombreParcial(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
