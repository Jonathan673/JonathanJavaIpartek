package com.floristeria.dataaccess;

import com.floristeria.entities.Producto;

public interface Dao<T> {
	Iterable<T> ObtenerTodosLosProductos();
	T ObtenerPorId(Long id);
	T InsertarProducto(Producto producto);
	T ModificarProducto(Producto producto);
	void EliminarProducto(Long id);
}
