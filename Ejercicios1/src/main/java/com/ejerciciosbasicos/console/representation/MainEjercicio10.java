package com.ejerciciosbasicos.console.representation;

import java.util.Scanner;

public class MainEjercicio10 {

	public static void main(String[] args) {
		// Programa Java que lea un número entero de 3 cifras y muestre por separado las cifras del número.
		Scanner sc = new Scanner(System.in);
		int num;
		boolean introducidoCorrectamente = false;
		
		System.out.println("Introduce un número de 3 cifras");
		num = sc.nextInt();
		if(num <100 || num>999) {
			do {
				System.out.println("Introduce bien el numero, entre el 100 y el 999");
				num = sc.nextInt();
				if(num <100 || num>999) {
					introducidoCorrectamente = false;
				}else {
					introducidoCorrectamente = true;
				}
			}while(!introducidoCorrectamente);
		}else {
			introducidoCorrectamente = true;
		}
		sc.close();
		System.out.println("Tu numero es "+num);
        System.out.println("Primera cifra de " + num + " es " + (num/100));
        System.out.println("segunda central de " + num + " es " + (num/10)%10);
        System.out.println("Última cifra  de " + num + " es " + (num%10));
	}
}
