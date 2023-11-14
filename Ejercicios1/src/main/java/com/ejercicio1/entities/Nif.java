package com.ejercicio1.entities;

import java.util.Scanner;

public class Nif {
	private int dni;
	private char letra;

	// Constructores
	public Nif() {
	}

	public Nif(int dni) {
		this.dni = dni;
		letra = calcularLetra();
	}

	// Método para calcular la letra del NIF
	private char calcularLetra() {
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		return letras[dni % 23];
	}

	// Método para leer por teclado el número de DNI y calcular la letra
	public void leer() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Introduce dni sin letra: ");
			dni = sc.nextInt();
		} while (dni <= 0);
		sc.close();
		letra = calcularLetra();
	}

	// toString
	@Override
	public String toString() {
		return dni + "-" + letra;
	}
}
