package com.zamazor.logicanegocio;

import com.zamazor.entidades.Producto;

public interface UsuarioNegocio {
	Iterable<Producto> listadoProductos();
	Producto datosProducto(Long id);
}
