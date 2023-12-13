package com.floristeriaSpring.accesodatos;

import com.floristeriaSpring.entidades.Producto;

public interface DaoProducto extends Dao<Producto>{
	Iterable<Producto> obtenerPorNombreParcial(String nombre);
}
