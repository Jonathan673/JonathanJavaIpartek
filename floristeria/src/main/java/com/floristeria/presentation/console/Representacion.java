package com.floristeria.presentation.console;

import java.math.BigDecimal;
import java.util.Scanner;

import com.floristeria.entities.Producto;

public class Representacion {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		Producto producto;
		
		
		Long id;
		String nombre;
		Integer unidades;
		BigDecimal precio;
		String tipoProducto;
		
		System.out.println("Indique el id del producto");
		id = sc.nextLong();
		System.out.println("Indique el nombre del producto");
		nombre = sc.next();
		System.out.println("Indique las unidades qu dispone del producto");
		unidades = sc.nextInt();
		System.out.println("Indique el precio del producto");
		precio = sc.nextBigDecimal();
		System.out.println("Indique el tipo de producto introducido");
		tipoProducto = sc.next();
		
		producto = new Producto(id, nombre, tipoProducto,precio,unidades);
		
		
		System.out.println(producto);
		
	}

}
