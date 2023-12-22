package com.amazonia2.logicanegocio;

import com.amazonia2.entidades.Carrito;
import com.amazonia2.entidades.Producto;
import com.amazonia2.entidades.Usuario;

public interface UsuarioNegocio {
	Iterable<Producto> listadoProductos();

	Producto detalleProducto(Long id);
	
	Usuario loguear(String email, String password);
	
	long cuantosUsuariosHay();
	
	long cuantosProductosHay();
	
	void agregarProductoACarrito(Long id, Carrito carrito);
	void agregarProductoACarrito(Producto producto, Carrito carrito);
}
