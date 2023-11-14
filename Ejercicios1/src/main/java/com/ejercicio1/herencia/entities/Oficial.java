package com.ejercicio1.herencia.entities;

public class Oficial extends Operario{
	public Oficial(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString() + " -> Oficial";
	}
	
}
