package com.inmobiliariaPruebaSpring.accesodatos;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;

public interface DaoEstablecimiento extends Dao<Establecimiento>{
	Iterable<Establecimiento> obtenerPorLocalidad(String localidad);
}
