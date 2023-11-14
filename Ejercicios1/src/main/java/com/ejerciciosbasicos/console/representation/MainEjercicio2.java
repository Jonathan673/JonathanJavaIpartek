package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio2 {

	public static void main(String[] args) {
		// Programa Java que lea un nombre y muestre por pantalla
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un nombre: ");
		String nombre = sc.next();
		sc.close();
		
		System.out.println("El nombre es: "+nombre);
	}

}
