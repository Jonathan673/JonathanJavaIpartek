package com.floristeria2sprint.accesodatos;

import java.time.LocalDate;

import com.floristeria2sprint.entidades.Producto;


public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> obtenerPorNombreParcial(String nombre);
	Iterable<Producto> obtenerCaducados();
	Iterable<Producto> obtenerCaducados(LocalDate fecha);
}
