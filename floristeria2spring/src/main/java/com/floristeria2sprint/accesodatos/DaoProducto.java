package com.floristeria2sprint.accesodatos;


import com.floristeria2sprint.entidades.Producto;


public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> obtenerPorNombreParcial(String nombre);
}
