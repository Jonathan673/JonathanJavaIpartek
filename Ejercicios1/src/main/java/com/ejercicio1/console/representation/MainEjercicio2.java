package com.ejercicio1.console.representation;

import java.util.Scanner;

import com.ejercicio1.entities.Contador;

public class MainEjercicio2 {

	public static void main(String[] args) {
		//main para probar el funcionamiento de la clase Contador
		Scanner sc = new Scanner(System.in);

		Contador contador = new Contador();
		System.out.println("Introduzca un numero");
		contador.setCont(sc.nextInt());
		sc.close();

		// System.out.println(contador.getCont());
		contador.decrementar();
		System.out.println("Le restamos 1: " + contador.getCont());
		contador.incrementar();
		System.out.println("Le sumamos 1: " + contador.getCont());
	}

}
