package com.ejercicio1.herencia.entities;

public class EmpleadoHerencia {
	//variables
	private String nombre;

	//constructores
	public EmpleadoHerencia(String nombre) {
		this.setNombre(nombre);
	}
	public EmpleadoHerencia() {
		if(this.getNombre() ==null) {
			this.setNombre("Anónimo");
		}
	}

	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//toString()
	@Override
	public String toString() {
		return "Empleado " + nombre;
	}
	
}
