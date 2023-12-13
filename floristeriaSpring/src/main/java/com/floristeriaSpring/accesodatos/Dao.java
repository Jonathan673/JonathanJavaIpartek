package com.floristeriaSpring.accesodatos;

public interface Dao<T> {
	//CRUD
	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default void eliminar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	//lISTAS
	default Iterable<T> listarTodos(){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T listarPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
