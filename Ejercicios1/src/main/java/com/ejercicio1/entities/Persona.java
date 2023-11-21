package com.ejercicio1.entities;

import java.time.LocalDate;

public class Persona {
	private String nombre;
	private String direccion;
	private int codigoPostal;
	private String ciudad;
	private Fecha fechaNacimiento;

	public Persona(String nombre, String direccion, int codigoPostal, String ciudad, Fecha fechaNacimiento) {
		setNombre(nombre);
		setDireccion(direccion);
		setCodigoPostal(codigoPostal);
		setCiudad(ciudad);
		setFechaNacimiento(fechaNacimiento);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	public boolean EsMayorDeEdad() {
		boolean mayorDeEdad = true;
		
		if((LocalDate.now().getYear() - fechaNacimiento.getAño()) < 18) {
			mayorDeEdad = false;
		}
		
		return mayorDeEdad;
	}
	
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", ciudad="
				+ ciudad + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
