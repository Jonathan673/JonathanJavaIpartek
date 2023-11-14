package com.zamazor.presentacion.consola;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.zamazor.accesodatos.DaoProducto;
import com.zamazor.accesodatos.DaoProductoMemoria;
import com.zamazor.entidades.Producto;

public class DaoProductoMemoriaPrueba {

	public static void main(String[] args) {
		// Polimorfismo, declaramos lo mas generico pero instanciamos algo mas
		// especifico
		DaoProducto dao = new DaoProductoMemoria();

		dao.insertar(new Producto());
		dao.insertar(new Producto("Producto prueba"));
		dao.insertar(new Producto("Producto prueba", new BigDecimal("123.4")));
		dao.insertar(new Producto("Producto prueba", LocalDate.now(), new BigDecimal("123.4")));
		

		Producto producto = dao.obtenerPorId(3L);

		producto.setNombre("Modificado");
		dao.modificar(producto);
		producto = new Producto(1L, "Modificado desde cero", null, new BigDecimal("123.4"));
		dao.modificar(producto);
		
		dao.borrar(2L);

		for (Producto p : dao.obtenerTodos()) {
			System.out.println(p);
		}
		System.out.println("\n Listado por nombre");
		for (Producto p : dao.obtenerPorNombre("Mod")) {
			System.out.println(p);
		}
	}

}
