package com.amazonia2.accesodatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.amazonia2.entidades.Producto;

public class DaoProductoSqlite extends DaoSqlite<Producto> implements DaoProducto {
//	private DaoProductoSqlite() {}
//	private static final DaoProductoSqlite INSTANCIA = new DaoProductoSqlite();
//	public static DaoProductoSqlite obtenerInstancia() {
//		return INSTANCIA;
//	}
	
	private static final String SQL_SELECT = "SELECT id, codigo_barras, nombre, precio, fecha_caducidad, unidades FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_CADUCADOS = SQL_SELECT + " WHERE fecha_caducidad < ?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO productos (codigo_barras, nombre, precio, fecha_caducidad, unidades) VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET codigo_barras=?, nombre=?, precio=?, fecha_caducidad=?, unidades=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	public DaoProductoSqlite(String url, String user, String pass) {
		super(url);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
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
	public Producto obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			Producto producto;
			try (ResultSet rs = pst.executeQuery()) {
				producto = null;

				if (rs.next()) {
					producto = filaAObjeto(rs);
				}

				return producto;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del id " + id, e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			producto.setId(null);
			objetoAFila(producto, pst);

			ejecutarCambio(pst);

			return producto;

		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la inserción de " + producto, e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			objetoAFila(producto, pst);

			ejecutarCambio(pst);

			return producto;

		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la inserción de " + producto, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			ejecutarCambio(pst);

		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del id " + id, e);
		}
	}

	@Override
	public Iterable<Producto> obtenerPorNombreParcial(String nombre) {
		if (nombre == null) {
			throw new AccesoDatosException("No se ha proporcionado ningún nombre para la búsqueda");
		}

		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {

			pst.setString(1, "%" + nombre + "%");

			ArrayList<Producto> productos;

			try (ResultSet rs = pst.executeQuery()) {
				productos = new ArrayList<Producto>();

				Producto producto;

				while (rs.next()) {
					producto = filaAObjeto(rs);

					productos.add(producto);
				}

				return productos;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del nombre " + nombre, e);
		}
	}

	@Override
	public Iterable<Producto> obtenerCaducados() {
		return obtenerCaducados(LocalDate.now());
	}

	@Override
	public Iterable<Producto> obtenerCaducados(LocalDate fecha) {
		if (fecha == null) {
			throw new AccesoDatosException("No se ha proporcionado ninguna fecha para la búsqueda");
		}

		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_CADUCADOS);) {

			pst.setString(1, fecha.toString());

			ArrayList<Producto> productos;

			try (ResultSet rs = pst.executeQuery()) {
				productos = new ArrayList<Producto>();

				Producto producto;

				while (rs.next()) {
					producto = filaAObjeto(rs);

					productos.add(producto);
				}

				return productos;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los registros", e);
		}
	}

	@Override
	protected void objetoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getCodigoBarras());
		pst.setString(2, producto.getNombre());
		pst.setBigDecimal(3, producto.getPrecio());
		LocalDate fecha = producto.getFechaCaducidad();
		pst.setString(4, fecha != null ? fecha.toString() : null);
		pst.setObject(5, producto.getUnidades());

		if (producto.getId() != null) {
			pst.setLong(6, producto.getId());
		}
	}

	@Override
	protected Producto filaAObjeto(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String codigoBarras = rs.getString("codigo_barras");
		String nombre = rs.getString("nombre");
		BigDecimal precio = rs.getBigDecimal("precio");
		String sFecha = rs.getString("fecha_caducidad");
		LocalDate fechaCaducidad = sFecha == null || sFecha.trim().length() == 0 ? null : LocalDate.parse(sFecha);
		String sUnidades = rs.getString("unidades");
		Integer unidades = sUnidades == null || sUnidades.trim().length() == 0 ? null: Integer.valueOf(sUnidades);

		return new Producto(id, codigoBarras, nombre, precio, fechaCaducidad, unidades);
	}
}