package com.recetas.servicios;

import com.recetas.entidades.Receta;

public interface LogicaAdmin {
	Iterable <Receta> listarTodo();
	Receta insertar();
}
