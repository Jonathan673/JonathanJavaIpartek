package com.ejercicio1.herencia.entities;

public class Operario extends EmpleadoHerencia{
	public Operario(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString() + " -> Operario";
	}
	
}
