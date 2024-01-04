package com.inmobiliariaPruebaSpring.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;
import com.inmobiliariaPruebaSpring.logicanegocio.AdminNegocio;
import com.inmobiliariaPruebaSpring.logicanegocio.UsuarioNegocio;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class IndexController {

	private UsuarioNegocio negocio;
	private AdminNegocio adminNegocio;

	public IndexController(UsuarioNegocio negocio, AdminNegocio adminNegocio) {
		this.negocio = negocio;
		this.adminNegocio = adminNegocio;
	}


	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("establecimientos", negocio.obtenerTodos());
		return "index";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("establecimientos", negocio.obtenerPorId(id));
		return "detalle";
	}
	
	
	
	
//	@GetMapping("/add")
	@PostMapping
	public String post(Model modelo, @Valid Establecimiento establecimiento) {
		adminNegocio.insertar(establecimiento);
		return "redirect:/";
	}

	
	
	
	@GetMapping("/borrar")
	public String borrar(Long id) {
		adminNegocio.eliminar(id);
		return "redirect:/";
	}

}
