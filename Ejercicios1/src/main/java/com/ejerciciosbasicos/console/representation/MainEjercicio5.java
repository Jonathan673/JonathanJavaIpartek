package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio5 {

	public static void main(String[] args) {
//		Ejercicio 5. Programa que lee por teclado el valor del radio de una circunferencia y 
//		calcula y muestra por pantalla la longitud y el área de la circunferencia. 
//Math.PI
//		Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2
		Scanner sc = new Scanner(System.in);
		float radio, longitud, area;

		System.out.println("Pasame el valos del radio de una circunferencia cualquiera ");
		radio = sc.nextFloat();
		sc.close();

		longitud = (float) (2 * Math.PI * radio);
		area = (float) (Math.PI * Math.pow(radio, 2));
		
		System.out.println("La longitud es "+longitud+" y el area es "+area);
	}
}
