package com.repaso.accesodatos;

public interface Dao<T> {
	Iterable<T>obtenerTodos();
	T obtenerPorId();
	
	T insertar(T objeto);
	T modificar(T objeto);
	T eliminar(T objeto);
}
