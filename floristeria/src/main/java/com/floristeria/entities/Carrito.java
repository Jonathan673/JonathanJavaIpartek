package com.floristeria.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carrito {
	private Long id;
	private Usuario usuario;

	private Map<Long, Producto> productos = new HashMap<>();

	// getter and setter
	public Set<Producto> getProductos() {
		return new HashSet<Producto>(productos.values());
	}

	// metodos internos
	public void addProducto(Producto producto) {
		productos.put(producto.getId(), producto);
	}

	public void updateUnidades(Long id, Integer unidades) {
		productos.get(id).setUnidades(unidades);
	}

	public void removeProducto(Long id) {
		productos.remove(id);
	}

	public Producto getProducto(Long id) {
		return productos.get(id);
	}

	public int getNumeroProductos() {
		return productos.size();
	}
}
