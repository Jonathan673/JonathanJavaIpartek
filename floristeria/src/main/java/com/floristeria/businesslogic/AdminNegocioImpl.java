package com.floristeria.businesslogic;

import com.floristeria.entities.Producto;
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
	
}
