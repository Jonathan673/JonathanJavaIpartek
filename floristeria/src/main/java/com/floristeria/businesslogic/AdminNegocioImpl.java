package com.floristeria.businesslogic;

import com.floristeria.entities.Producto;
import com.floristeria.entities.Proveedor;
import com.floristeria.globals.Global;

public class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio {
	
	@Override
	public Producto insertarProducto(Producto producto) {
		return Global.FABRICA.obtenerDaoProducto().InsertarProducto(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return Global.FABRICA.obtenerDaoProducto().ModificarProducto(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		Global.FABRICA.obtenerDaoProducto().EliminarProducto(id);		
	}

	@Override
	public Proveedor insertarProveedor(Proveedor proveedor) {
		return Global.FABRICA.obtenerDaoProveedor().InsertarProducto(proveedor);
	}

	@Override
	public Proveedor modificarProveedor(Proveedor proveedor) {
		return Global.FABRICA.obtenerDaoProveedor().ModificarProducto(proveedor);
	}

	@Override
	public void borrarProveedor(Long id) {
		Global.FABRICA.obtenerDaoProveedor().EliminarProducto(id);
		
	}

	@Override
	public Iterable<Proveedor> listadoProveedores() {
		return Global.FABRICA.obtenerDaoProveedor().ObtenerTodosLosProductos();
	}

	@Override
	public Proveedor detalleProveedor(Long id) {
		return Global.FABRICA.obtenerDaoProveedor().ObtenerPorId(id);
	}
	
}
