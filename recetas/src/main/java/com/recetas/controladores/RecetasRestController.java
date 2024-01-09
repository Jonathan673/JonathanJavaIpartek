package com.recetas.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recetas.entidades.Receta;
import com.recetas.servicios.LogicaAdmin;

@RestController
@RequestMapping("/api/v1/recetas")
public class RecetasRestController {
	private LogicaAdmin adminServicio;
	
	public RecetasRestController(LogicaAdmin logicaAdmin) {
		this.adminServicio = logicaAdmin;
	}
	
	@GetMapping
	public Iterable<Receta> ObtenerTodos(){
		return adminServicio.listarTodo();
	}
}
