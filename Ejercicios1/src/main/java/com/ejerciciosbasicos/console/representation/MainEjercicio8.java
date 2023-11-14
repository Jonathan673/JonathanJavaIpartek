package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio8 {

	public static void main(String[] args) {
//		Programa que tome como dato de entrada un número que corresponde a la 
//		longitud del radio una esfera y nos calcula y escribe el volumen de la 
//		esfera que se corresponden con dicho radio.
//
//		La fórmula para calcular el volumen de la esfera es
//		v = (4/3)*PI*r^3
		Scanner sc = new Scanner(System.in);
		
		float radio, volumen;
		
		System.out.println("Introduce el radio de una esfera y te sacaré su volumen");
		radio = sc.nextFloat();
		sc.close();
		volumen = (float) ((4/3)*Math.PI*Math.pow(radio, 3));
		
		System.out.println("El volument es de "+volumen);
	}

}
