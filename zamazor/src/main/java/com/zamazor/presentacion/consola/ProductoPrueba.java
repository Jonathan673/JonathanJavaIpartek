package com.zamazor.presentacion.consola;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.zamazor.entidades.Producto;

public class ProductoPrueba {

	public static void main(String[] args) {
		Producto producto = new Producto(null,"Prueba",null,BigDecimal.TEN);
		
		producto.setId(5L);
		producto.setNombre("Productote");
		producto.setFechaCaducidad(LocalDate.of(2024, 1, 2));
		producto.setPrecio(new BigDecimal("1234.5"));
		
		System.out.println(producto);
	}

}
