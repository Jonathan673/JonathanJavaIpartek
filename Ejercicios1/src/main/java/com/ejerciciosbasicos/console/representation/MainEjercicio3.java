package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio3 {

	public static void main(String[] args) {
		// Escribe un programa Java que lee un número entero por teclado 
		// y obtiene y muestra por pantalla el doble y el triple de ese número.
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.println("Introduce un número: ");
		num = sc.nextInt();
		sc.close();
		
		System.out.println("El doble de ese número es: "+num*2);
		System.out.println("El triple de ese número es: "+num*3);
	}

}
