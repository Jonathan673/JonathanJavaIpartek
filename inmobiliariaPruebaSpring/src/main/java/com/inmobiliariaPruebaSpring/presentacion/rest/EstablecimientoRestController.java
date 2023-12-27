package com.inmobiliariaPruebaSpring.presentacion.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;
import com.inmobiliariaPruebaSpring.logicanegocio.UsuarioNegocio;

@RestController
@RequestMapping("/api/v1/establecimientos")
public class EstablecimientoRestController {
	private UsuarioNegocio usuarioNegocio;
	
	public EstablecimientoRestController(UsuarioNegocio usuarioNegocio) {
		this.usuarioNegocio = usuarioNegocio;
	}
	
	@GetMapping
	public Iterable<Establecimiento> ObtenerTodos(){
		return usuarioNegocio.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Establecimiento ObtenerPorId(@PathVariable Long id) {
		return usuarioNegocio.obtenerPorId(id);
	}
}
