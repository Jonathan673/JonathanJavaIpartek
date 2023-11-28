package com.floristeria.dataaccess;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import com.floristeria.dataaccess.AccesoDatosException;
import com.floristeria.entities.Producto;

public class DaoProductoSqlite extends DaoSqlite<Producto> implements DaoProducto{
	public DaoProductoSqlite(String url, String user, String pass) {
		super(url);
	}

	private static final String SQL_INSERT = "INSERT INTO productos (codigo_barras, nombre, precio, fecha_caducidad, unidades) VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET codigo_barras=?, nombre=?, precio=?, fecha_caducidad=?, unidades=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	private static final String SQL_SELECT = "SELECT id, nombre, tipo_planta, precio, unidades FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";
	
	@Override
	public Iterable<Producto> ObtenerTodosLosProductos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var productos = new ArrayList<Producto>();

			Producto producto;

			while (rs.next()) {
				producto = filaAObjeto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los registros", e);
		}
	}

	@Override
	public Producto ObtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				ResultSet rs = pst.executeQuery()) {
			pst.setLong(1, id);

			Producto producto = null;

			if (rs.next()) {
				producto = filaAObjeto(rs);

			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del id " + id, e);
		}
	}

	@Override
	public Producto InsertarProducto(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				ResultSet rs = pst.executeQuery()) {
			objetoAFila(producto, pst);

			ejecutarCambio(pst);

			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la insercion  " + producto, e);
		}
	}

	@Override
	public Producto ModificarProducto(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				ResultSet rs = pst.executeQuery()) {
			objetoAFila(producto, pst);

			ejecutarCambio(pst);

			
			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la modificacion " + producto, e);
		}
		
	}

	@Override
	public void EliminarProducto(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				ResultSet rs = pst.executeQuery()) {
			pst.setLong(1, id);

			ejecutarCambio(pst);

		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la eliminacion " + id, e);
		}
	}

	@Override
	public Iterable<Producto> obtenerPorNombreParcial(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Producto filaAObjeto(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String tipo_planta = rs.getString("codigo_barras");
		BigDecimal precio = rs.getBigDecimal("precio");
		String sUnidades = rs.getString("unidades");
		Integer unidades = sUnidades == null || sUnidades.trim().length() == 0 ? null: Integer.valueOf(sUnidades);

		return new Producto(id, nombre, tipo_planta, precio, unidades);
	}

	@Override
	protected void objetoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setString(2, producto.getProductTipe());
		pst.setBigDecimal(3, producto.getPrecio());
		pst.setObject(4, producto.getUnidades());

		if (producto.getId() != null) {
			pst.setLong(5, producto.getId());
		}
		
	}
}
