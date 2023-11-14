package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio1 {

	public static void main(String[] args) {
		// Programa Java que lea dos números enteros por teclado y los muestre por
		// pantalla.
		Scanner sc = new Scanner(System.in);

		int num1, num2;

		System.out.println("Introduzca un número: ");
		num1 = sc.nextInt();
		System.out.println("Introduzca un número: ");
		num2 = sc.nextInt();
		sc.close();
		
		System.out.println("Los números introducidos son: "+num1+" y "+num2);
	}

}
