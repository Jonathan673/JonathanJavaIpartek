package com.ejerciciosbasicos.console.representation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainEjercicio6 {

	public static void main(String[] args) {
		// Ejercicio 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se
		// lee por teclado.
		//el decimalformat es para poder indicar el numero de decimales que queremos obtener.
		final DecimalFormat df = new DecimalFormat("0.00");
		
		Scanner sc = new Scanner(System.in);
		
		double kmHora;

		System.out.println("Escribeme una cantidad de Km/h");
		kmHora = sc.nextDouble();
		sc.close();
		
		System.out.println("Eso son un total de " + df.format(kmHora * 1000 / 3600) + " m/s");
	}

}
