package com.ejercicio1.herencia.entities;

public class Directivo extends EmpleadoHerencia{
	public Directivo(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString() + " -> Directivo";
	}
	
}
