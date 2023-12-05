package com.floristeria.businesslogic;

import com.floristeria.entities.Producto;
import com.floristeria.entities.Usuario;

public interface UsuarioNegocio {
	Iterable<Producto> listadoProductos();

	Producto detalleProducto(Long id);
	
	Usuario loguear(String email, String password);
}
