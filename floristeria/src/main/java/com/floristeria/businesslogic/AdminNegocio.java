package com.floristeria.businesslogic;

import com.floristeria.entities.Producto;

public interface AdminNegocio extends UsuarioNegocio {
	Producto insertarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
}
