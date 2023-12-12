package com.floristeria2sprint.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floristeria2sprint.entidades.Producto;
import com.floristeria2sprint.logicanegocio.AdminNegocio;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductosRestController {
	@Autowired
	private AdminNegocio negocio;
	
	
	@GetMapping
	public Iterable<Producto> getTodos() {
		return negocio.listadoProductos();
	}
	
	@GetMapping("/{id}")
	public Producto obtenerProducto(@PathVariable Long id) {
		return negocio.detalleProducto(id);
	}
	
//	@GetMapping
//	public Producto post(@RequestBody Producto producto) {
//		return negocio.insertarProducto(producto);	
//	}
//	
//	@GetMapping("/{id}")
//	public Producto put(@PathVariable Long id, @RequestBody Producto producto) {
//		return negocio.modificarProducto(producto);
//	}
//	
//	@GetMapping("/{id}")
//	public void delete(@PathVariable Long id) {
//		negocio.borrarProducto(id);
//	}
	
	@GetMapping("/buscar/cuantos")
	public long buscarCuantos() {
		return negocio.cuantosProductosHay();
	}
}
