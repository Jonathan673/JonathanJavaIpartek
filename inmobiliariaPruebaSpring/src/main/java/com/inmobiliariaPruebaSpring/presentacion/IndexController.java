package com.inmobiliariaPruebaSpring.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inmobiliariaPruebaSpring.logicanegocio.UsuarioNegocio;

@Controller
@RequestMapping
public class IndexController {

	private UsuarioNegocio negocio;

	public IndexController(UsuarioNegocio negocio) {
		this.negocio = negocio;
	}

	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("establecimientos", negocio.obtenerTodos());
		return "index";
	}
}
