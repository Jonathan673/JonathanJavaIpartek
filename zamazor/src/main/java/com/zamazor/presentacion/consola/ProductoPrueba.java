package com.zamazor.presentacion.consola;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.zamazor.entidades.Producto;

public class ProductoPrueba {

	public static void main(String[] args) {
		Producto p = new Producto();
		System.out.println(p);
		Producto producto = new Producto(null,"Prueba",null,BigDecimal.TEN);
		
		producto.setId(5L);
		producto.setNombre("Productote");
		producto.setFechaCaducidad(LocalDate.of(2024, 2, 2));
		producto.setPrecio(new BigDecimal("1234.5"));
		
		System.out.println(producto);
		
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		//Comparamos con el meetodo equals de la clase
		System.out.println(p1.equals(p2));
		
		Producto p17 = new Producto(p1);
		p17.setNombre("Cambio");
		System.out.println(p1);
		System.out.println(p17);
	}

}
