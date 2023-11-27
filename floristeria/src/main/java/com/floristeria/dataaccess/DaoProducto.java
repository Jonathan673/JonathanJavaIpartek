package com.floristeria.dataaccess;

import com.floristeria.entities.Producto;

public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> obtenerPorNombreParcial(String nombre);
}
