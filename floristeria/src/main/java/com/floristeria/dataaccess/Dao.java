package com.floristeria.dataaccess;

public interface Dao<T> {
	Iterable<T> ObtenerTodosLosProductos();
	T ObtenerPorId();
	T InsertarProducto();
	T ModificarProducto();
	T EliminarProducto();
}
