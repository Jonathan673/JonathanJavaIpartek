package com.ejerciciosbasicos.console.representation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainEjercicio7 {

	public static void main(String[] args) {
		// Ejercicio 7. Programa lea la longitud de los catetos de un triángulo rectángulo y 
		// calcule la longitud de la hipotenusa según el teorema de Pitágoras.
		final DecimalFormat df = new DecimalFormat("0.00");
		Scanner sc = new Scanner(System.in);
		float cateto1,cateto2,hipotenusa;
		
		System.out.println("Indicame la londitud del primer cateto del triangulo: ");
		cateto1 = sc.nextFloat();
		System.out.println("Indicame la londitud del segundo cateto del triangulo: ");
		cateto2 = sc.nextFloat();
		sc.close();
		
		hipotenusa = (float) Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
		System.out.println("La hipotenusa del triangulo rectangulo es "+df.format(hipotenusa));
	}

}
