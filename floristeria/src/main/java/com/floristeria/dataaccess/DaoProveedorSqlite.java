package com.floristeria.dataaccess;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.floristeria.entities.Producto;
import com.floristeria.entities.Proveedor;

public class DaoProveedorSqlite extends DaoSqlite<Proveedor> implements DaoProveedor{

	private static final String SQL_INSERT = "INSERT INTO proveedores (nombre, direccion, numeroTelefono, web) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE proveedores SET nombre=?, direccion=?, numeroTelefono=?, web=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM proveedores WHERE id=?";
	private static final String SQL_SELECT = "SELECT id, nombre, direccion, numeroTelefono, web FROM proveedores";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	
	
	public DaoProveedorSqlite(String url, String user, String pass) {
		super(url);
	}

	
	
	@Override
	public Iterable<Proveedor> ObtenerTodosLosProductos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var proveedores = new ArrayList<Proveedor>();

			Proveedor proveedor;

			while (rs.next()) {
				proveedor = filaAObjeto(rs);

				proveedores.add(proveedor);
			}

			return proveedores;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los registros", e);
		}
	}

	@Override
	public Proveedor ObtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);

			Proveedor proveedor;
			try (ResultSet rs = pst.executeQuery()) {
				proveedor = null;

				if (rs.next()) {
					proveedor = filaAObjeto(rs);
				}

				return proveedor;
			}
			
			
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del id " + id, e);
		}
	}

	@Override
	public Proveedor InsertarProducto(Proveedor proveedor) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			proveedor.setId(null);
			objetoAFila(proveedor, pst);

			ejecutarCambio(pst);

			return proveedor;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la insercion  " + proveedor, e);
		}
	}

	@Override
	public Proveedor ModificarProducto(Proveedor proveedor) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			objetoAFila(proveedor, pst);

			ejecutarCambio(pst);

			
			return proveedor;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la modificacion " + proveedor, e);
		}
		
	}

	@Override
	public void EliminarProducto(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			ejecutarCambio(pst);

		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la eliminacion " + id, e);
		}
	}
	
	
	
	@Override
	protected Proveedor filaAObjeto(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String direccion = rs.getString("direccion");
		Integer numeroTelefono = rs.getInt("numeroTelefono");
		String web = rs.getString("web");

		return new Proveedor(id, nombre, direccion, numeroTelefono, web);
	}

	@Override
	protected void objetoAFila(Proveedor proveedor, PreparedStatement pst) throws SQLException {
		pst.setString(1, proveedor.getNombre());
		pst.setString(2, proveedor.getDireccion());
		pst.setInt(3, proveedor.getNumeroTelefono());
		pst.setObject(4, proveedor.getWebSite());

		if (proveedor.getId() != null) {
			pst.setLong(5, proveedor.getId());
		}
	}


}
