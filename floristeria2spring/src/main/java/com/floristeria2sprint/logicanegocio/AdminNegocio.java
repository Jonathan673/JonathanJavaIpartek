package com.floristeria2sprint.logicanegocio;

import com.floristeria2sprint.entidades.Producto;
import com.floristeria2sprint.entidades.Rol;

public interface AdminNegocio extends UsuarioNegocio {
	Producto insertarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
	
	Iterable<Rol> obtenerTodosLosRoles();
}
