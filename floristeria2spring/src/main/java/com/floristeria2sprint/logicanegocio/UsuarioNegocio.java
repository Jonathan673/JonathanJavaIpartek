package com.floristeria2sprint.logicanegocio;

import com.floristeria2sprint.entidades.Producto;
import com.floristeria2sprint.entidades.Usuario;

public interface UsuarioNegocio {
	Iterable<Producto> listadoProductos();

	Producto detalleProducto(Long id);
	
	Usuario loguear(String email, String password);
	
	long cuantosUsuariosHay();
	
	long cuantosProductosHay();
}
