package com.inmobiliariaPruebaSpring.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	T insertar(T objeto);
	T modificar(T objeto);
	void eliminar(Long id);
}
