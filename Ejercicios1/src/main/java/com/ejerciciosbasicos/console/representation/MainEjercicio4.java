package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio4 {

	public static void main(String[] args) {
		// Ejercicio 4: Programa que lea una cantidad de grados centígrados y la pase a
		// grados Fahrenheit.
		// La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
		// F = 32 + ( 9 * C / 5)
		Scanner sc = new Scanner(System.in);
		float gradosCentigrados, gradosFahrenheit;

		System.out.println("Dime cuantos grados hace hoy");
		gradosCentigrados = sc.nextFloat();
		sc.close();

		gradosFahrenheit = 32 + (9 * gradosCentigrados / 5);
		System.out.println("Eso son " + gradosFahrenheit+" grados fahrenheit");
		
	}

}
