package com.ejercicio1.herencia.entities;

public class Tecnico extends Operario{
	public Tecnico(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString() + " -> Técnico";
	}
	
}
