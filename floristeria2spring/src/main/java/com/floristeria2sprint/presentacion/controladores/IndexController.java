package com.floristeria2sprint.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.floristeria2sprint.logicanegocio.UsuarioNegocio;

@Controller
@RequestMapping
public class IndexController {
	@Autowired
	private UsuarioNegocio negocio;
	
	@ResponseBody
	@GetMapping("/index")
	public String index(Model modelo) {
		modelo.addAttribute("productos", negocio.listadoProductos());
		return "index";
		//return "index";
	}
	@ResponseBody
	@GetMapping("/detalle/{id}")
	public String hola(Model modelo, Long id) {
		modelo.addAttribute("productos", negocio.detalleProducto(id));
		return negocio.detalleProducto(id).toString();
	}
}
