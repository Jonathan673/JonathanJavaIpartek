package com.zamazor.accesodatos;

import java.util.TreeMap;

import com.zamazor.entidades.Producto;

public class DaoProductoMemoria implements DaoProducto{

	private static final TreeMap<Long, Producto> productos = new TreeMap<>();
	
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto object) {
		// compruebame los productos de la lista, si es que hay, dame el ultimo 
		// id y guardame el nuevo producto +1
		Long id = productos.size() > 0 ? productos.lastKey() + 1L : 1L;
		object.setId(id);
		//clave bajo la que guardo algo, y lo que guardo
		productos.put(id, object);
		return object;
	}

	@Override
	public Producto modificar(Producto object) {
		
		return productos.put(object.getId(), object);
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		productos.remove(id);
		
	}

	@Override
	public Iterable<Producto> obtenerPorNombre(String nombreParcial) {
		//pasame el producto donde el nombre del producto contiene el nombre parcial
		// es un filtro, es similar a un for y un if al mismo tiempo
		// p = producto
		return productos.values().stream().filter(p -> p.getNombre().contains(nombreParcial)).toList();
	}

}
