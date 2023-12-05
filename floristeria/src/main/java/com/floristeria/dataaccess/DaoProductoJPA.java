package com.floristeria.dataaccess;


import com.floristeria.entities.Producto;

public class DaoProductoJPA extends DaoJPA implements DaoProducto {

	public DaoProductoJPA(String ignorado1, String ignorado2, String ignorado3) {
		super(ignorado1, ignorado2, ignorado3);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Producto> ObtenerTodosLosProductos() {
		// Devuelveme una lista de productosde la tabla productos
		return (Iterable<Producto>) transaccion(em -> em.createQuery("from Producto", Producto.class).getResultList());

//		try (Connection con = obtenerConexion();
//				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
//				ResultSet rs = pst.executeQuery()) {
//			var productos = new ArrayList<Producto>();
//
//			Producto producto;
//
//			while (rs.next()) {
//				producto = filaAObjeto(rs);
//
//				productos.add(producto);
//			}
//
//			return productos;
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error en la consulta de todos los registros", e);
//		}
	}

	@Override
	public Producto ObtenerPorId(Long id) {
		// Devuelveme el producto con el id que te paso
		return (Producto) transaccion(em -> em.find(Producto.class, id));

//		try (Connection con = obtenerConexion();
//				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
//			pst.setLong(1, id);
//
//			Producto producto;
//			try (ResultSet rs = pst.executeQuery()) {
//				producto = null;
//
//				if (rs.next()) {
//					producto = filaAObjeto(rs);
//				}
//
//				return producto;
//			}
//			
//			
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error en la consulta del id " + id, e);
//		}
	}

	@Override
	public Producto InsertarProducto(Producto producto) {
		// Haz una instancia del producto que te voy a introducir e insertalo en la
		// tabla
		return (Producto) transaccion(em -> {
			em.persist(producto);
			return producto;
		});
//		try (Connection con = obtenerConexion();
//				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
//			producto.setId(null);
//			objetoAFila(producto, pst);
//
//			ejecutarCambio(pst);
//
//			return producto;
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error en la insercion  " + producto, e);
//		}
	}

	@Override
	public Producto ModificarProducto(Producto producto) {
		// Actualizame el producto con los datos del producto que te he pasado
		return (Producto) transaccion(em -> em.merge(producto));
//		try (Connection con = obtenerConexion();
//				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
//			objetoAFila(producto, pst);
//
//			ejecutarCambio(pst);
//
//			
//			return producto;
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error en la modificacion " + producto, e);
//		}

	}

	@Override
	public void EliminarProducto(Long id) {
		// buscame el producto que contenga esta id y eliminalo
		transaccion(em -> {
			em.remove(em.find(Producto.class, id));
			return null;
		});
//		try (Connection con = obtenerConexion();
//				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
//			pst.setLong(1, id);
//
//			ejecutarCambio(pst);
//
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error en la eliminacion " + id, e);
//		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Producto> obtenerPorNombreParcial(String nombre) {
		return (Iterable<Producto>) transaccion(
				em -> em.createQuery("from Producto p where p.nombre like '%?1%'", Producto.class)
						.setParameter(1, nombre).getResultList());
	}

//	@Override
//	public Iterable<Producto> obtenerPorNombreParcial(String nombre) {
//		if (nombre == null) {
//			throw new AccesoDatosException("No se ha proporcionado ningún nombre para la búsqueda");
//		}
//
//		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {
//
//			pst.setString(1, "%" + nombre + "%");
//
//			ArrayList<Producto> productos;
//
//			try (ResultSet rs = pst.executeQuery()) {
//				productos = new ArrayList<Producto>();
//
//				Producto producto;
//
//				while (rs.next()) {
//					producto = filaAObjeto(rs);
//
//					productos.add(producto);
//				}
//
//				return productos;
//			}
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error en la consulta del nombre " + nombre, e);
//		}
//	}
//
//	@Override
//	protected Producto filaAObjeto(ResultSet rs) throws SQLException {
//		Long id = rs.getLong("id");
//		String nombre = rs.getString("nombre");
//		String tipo_producto = rs.getString("tipo_producto");
//		BigDecimal precio = rs.getBigDecimal("precio");
//		String sUnidades = rs.getString("unidades");
//		Integer unidades = sUnidades == null || sUnidades.trim().length() == 0 ? null: Integer.valueOf(sUnidades);
//
//		return new Producto(id, nombre, tipo_producto, precio, unidades);
//	}
//
//	@Override
//	protected void objetoAFila(Producto producto, PreparedStatement pst) throws SQLException {
//		pst.setString(1, producto.getNombre());
//		pst.setString(2, producto.getProductTipe());
//		pst.setBigDecimal(3, producto.getPrecio());
//		pst.setObject(4, producto.getUnidades());
//
//		if (producto.getId() != null) {
//			pst.setLong(5, producto.getId());
//		}
//		
//	}

}
