package com.inmobiliariaPruebaSpring.logicanegocio;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;

public interface UsuarioNegocio {
	Iterable<Establecimiento> obtenerTodos();
	Establecimiento obtenerPorId(Long id);
}
