package com.repaso.accesodatos;

import java.time.LocalDate;

import com.repaso.entidades.Producto;

public interface DaoProducto extends Dao<Producto>{
	Iterable<Producto> ObtenerPorNombre(String nombre);
	Iterable<Producto> ObtenerCaducados();
	Iterable<Producto> ObtenerCaducadosPorFecha(LocalDate fecha);
	
}
