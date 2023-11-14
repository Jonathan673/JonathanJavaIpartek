package com.zamazor.accesodatos;

//Data Access Object
// "T" significa genérico, usaremos de esta manera esta interfaz para mas de una entidad
public interface Dao<T> {
	Iterable<T> obtenerTodos();

	T obtenerPorId(Long id);

	T insertar(T object);

	T modificar(T object);

	void borrar(Long id);
}
