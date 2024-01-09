package com.recetas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recetas.entidades.Receta;
import com.recetas.servicios.LogicaAdmin;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class IndexController {
	private LogicaAdmin adminServicio;
	
	public IndexController(LogicaAdmin logicaAdmin) {
		this.adminServicio = logicaAdmin;
	}
	
	@GetMapping("/")
	public String index(Model modelo){
		modelo.addAttribute("recetas", adminServicio.listarTodo());
		return "mostrar";
	}
	
//	@GetMapping("/add")
	@PostMapping
	public String post(Model modelo, @Valid Receta receta) {
		adminServicio.insertar(receta);
		return "redirect:/";
	}
}
