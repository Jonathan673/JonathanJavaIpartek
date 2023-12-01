package com.floristeria.businesslogic;

import com.floristeria.entities.Producto;
import com.floristeria.entities.Proveedor;

public interface AdminNegocio extends UsuarioNegocio {
	Producto insertarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
	
	
	Iterable<Proveedor> listadoProveedores();
	Proveedor detalleProveedor(Long id);
	Proveedor insertarProveedor(Proveedor proveedor);
	Proveedor modificarProveedor(Proveedor proveedor);
	void borrarProveedor(Long id);
}
