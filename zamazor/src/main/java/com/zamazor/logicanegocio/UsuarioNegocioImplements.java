package com.zamazor.logicanegocio;



import java.util.logging.Logger;

import com.zamazor.accesodatos.DaoProducto;
import com.zamazor.accesodatos.DaoProductoMemoria;
import com.zamazor.entidades.Producto;

public class UsuarioNegocioImplements implements UsuarioNegocio{
	private static final DaoProducto dao = new DaoProductoMemoria();
	
	private static final Logger Log = Logger.getLogger(UsuarioNegocioImplements.class.getName());

	@Override
	public Iterable<Producto> listadoProductos() {
		Log.info("Se ha pedido un listado de productos ");
		Iterable<Producto> productos = dao.obtenerTodos();
		Log.info("Se ha obtenido un listado de productos");
		return productos;
	}

	@Override
	public Producto datosProducto(Long id) {
		Log.info("Se ha pedido un listado de productos "+ id);
		Producto producto = dao.obtenerPorId(id);
		if(producto == null) {
			Log.warning("No se ha encontrado el producto id "+id);
		}else {
			Log.info("Se ha obtenido el producto "+ producto);
		}
		return producto;
	}

}
