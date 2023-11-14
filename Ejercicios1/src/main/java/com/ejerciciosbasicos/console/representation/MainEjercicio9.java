package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio9 {

	public static void main(String[] args) {
//		Programa Java que calcule el área de un triángulo en 
//		función de las longitudes de sus lados (a, b, c), según la siguiente fórmula:  
//			Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))
//			donde p =  (a+b+c)/2
//			Para calcular la raíz cuadrada se utiliza el método Math.sqrt() 

		Scanner sc = new Scanner(System.in);
		double a, b, c, p, area;

		System.out.println("Pasame del la longitud del un lado del triangulo");
		a = sc.nextDouble();
		System.out.println("Pasame del la longitud del otro lado del triangulo");
		b = sc.nextDouble();
		System.out.println("Pasame del la longitud del ultimo lado del triangulo");
		c = sc.nextDouble();
		sc.close();

		p = (a + b + c) / 2;
		area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		System.out.println("El area del triangulo es de " + area);
	}
}
