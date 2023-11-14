package com.ejercicio1.console.representation;

import java.util.Scanner;

import com.ejercicio1.entities.Libro;

public class MainEjercicio3 {

	public static void main(String[] args) {
		// Main para probar el funcionamiento de la clase libro
		Scanner sc = new Scanner(System.in);
		
		//insercion de datos de prueba
		Libro libroNuevo= new Libro();
		Libro libro1 = new Libro("libro1", "Paco", 1, 2);
		Libro libro2 = new Libro("libro2", "P", 1, 0);
		Libro libro3 = new Libro("libro3", "Pepe", 4, 4);
		
		System.out.println("Titulo del libro: ");
		libroNuevo.setTitulo(sc.nextLine());
		System.out.println("Autor del libro: ");
		libroNuevo.setAutor(sc.nextLine());
		System.out.println("ejemplares disponibles: ");
		libroNuevo.setEjemplares(sc.nextInt());
		System.out.println("ejemplares prestados: ");
		libroNuevo.setEjemplaresPrestados(sc.nextInt());
		sc.close();

		//se comprueba que estan correctamente introducidos
		System.out.println(libro1 + "\n" + libro2 + "\n"+ libro3 + "\n"+ libroNuevo);
		
		//comprobacion del metodo prestamo
		System.out.println(libro1.Prestamo(libro1));
		System.out.println(libro1);
		
		//comprobacion del metodo devoluciones
		System.out.println(libro2.Devoluciones(libro2));
		System.out.println(libro2);
	}

}
