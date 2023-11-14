package com.zamazor.accesodatos;

import com.zamazor.entidades.Producto;

public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> obtenerPorNombre(String nombreProducto);
}
