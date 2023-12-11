package com.floristeria2sprint.accesodatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.floristeria2sprint.entidades.Producto;

@Component
class DaoProductoJdbc implements DaoProducto {
	private static final String SQL_SELECT = "SELECT id, nombre, tipo_producto, precio, unidades FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_CUANTOS = "SELECT COUNT(*) FROM productos";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, tipo_producto, precio, unidades) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, tipo_producto=?, precio=?, unidades=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return jdbc.query(SQL_SELECT, new BeanPropertyRowMapper<Producto>(Producto.class));
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return jdbc.queryForObject(SQL_SELECT_ID, new BeanPropertyRowMapper<Producto>(Producto.class), id);
	}

	@Override
	public Producto insertar(Producto producto) {
		jdbc.update(SQL_INSERT, producto.getNombre(), producto.getProductTipe(), producto.getPrecio(), producto.getUnidades());
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		jdbc.update(SQL_UPDATE, producto.getNombre(), producto.getProductTipe(), producto.getPrecio(), producto.getUnidades(), producto.getId());
		return producto;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update(SQL_DELETE, id);
	}

	@Override
	public long cuantosHay() {
		return jdbc.queryForObject(SQL_SELECT_CUANTOS, Long.class);
	}

	@Override
	public Iterable<Producto> obtenerPorNombreParcial(String nombre) {
		return jdbc.query(SQL_SELECT_NOMBRE, new BeanPropertyRowMapper<Producto>(Producto.class), "%" + nombre + "%");
	}

}
