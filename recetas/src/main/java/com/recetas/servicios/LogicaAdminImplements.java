package com.recetas.servicios;

import org.springframework.stereotype.Service;

import com.recetas.entidades.Receta;

@Service
public class LogicaAdminImplements implements LogicaAdmin{

	@Override
	public Iterable<Receta> listarTodo() {
		return null;
	}

	@Override
	public Receta insertar() {
		return null;
	}

}
