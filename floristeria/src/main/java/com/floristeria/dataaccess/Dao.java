package com.floristeria.dataaccess;

public interface Dao<T> {
	default Iterable<T> ObtenerTodosLosProductos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T ObtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T InsertarProducto(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T ModificarProducto(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default void EliminarProducto(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
