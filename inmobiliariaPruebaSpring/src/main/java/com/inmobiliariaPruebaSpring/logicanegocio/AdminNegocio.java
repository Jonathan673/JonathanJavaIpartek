package com.inmobiliariaPruebaSpring.logicanegocio;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;

public interface AdminNegocio extends UsuarioNegocio{
	Establecimiento insertar(Establecimiento establecimiento);
	Establecimiento modificar(Establecimiento establecimiento);
	void eliminar(Long id);
}
