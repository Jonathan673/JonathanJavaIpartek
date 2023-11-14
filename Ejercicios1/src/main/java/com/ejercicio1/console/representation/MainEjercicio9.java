package com.ejercicio1.console.representation;

import com.ejercicio1.entities.Password;

public class MainEjercicio9 {

	public static void main(String[] args) {
		// Se crea una contraseña de longitud 12
		Password pass = new Password(12);
		// se muestra por pantalla
		System.out.println("Contraseña creada: " + pass.getContraseña());
		// Se muestra si es fuerte o no
		System.out.println(pass.esFuerte() ? "Es fuerte" : "No es fuerte");
		// Se introduce una nueva contraseña para modificar la anterior
		// Se muestra el resultado de la modificación
		if (pass.modificarContraseña()) {
			System.out.println("Nueva contraseña: " + pass.getContraseña());
		} else {
			System.out.println("La contraseña introducida no es fuerte");
			System.out.println("la contraseña original no ha sido modificada: " + pass.getContraseña());
		}
	}
}
