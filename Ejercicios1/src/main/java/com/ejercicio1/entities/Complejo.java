package com.ejercicio1.entities;

import java.util.Objects;

public class Complejo {
	private double real;
	private double imag;

	// Constructor por defecto de la clase
	public Complejo() {

	}

	// Constructor con parámetros
	public Complejo(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	// métodos setters y getters
	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	// metodos
	public Complejo sumar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real + c.real;
		aux.imag = imag + c.imag;
		return aux;
	}

	public Complejo restar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real - c.real;
		aux.imag = imag - c.imag;
		return aux;
	}

	public Complejo multiplicar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real * c.real - imag * c.imag;
		aux.imag = real * c.imag + imag * c.real;
		return aux;
	}

	public Complejo multiplicar(double n) {
		Complejo aux = new Complejo();
		aux.real = real * n;
		aux.imag = imag * n;
		return aux;
	}

	public Complejo dividir(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = (real * c.real + imag * c.imag) / (c.real * c.real + c.imag * c.imag);
		aux.imag = (imag * c.real - real * c.imag) / (c.real * c.real + c.imag * c.imag);
		return aux;
	}
	
	// Hashcode y equals
	@Override
	public int hashCode() {
		return Objects.hash(imag, real);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		return Double.doubleToLongBits(imag) == Double.doubleToLongBits(other.imag)
				&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real);
	}

	//  toString
	@Override
	public String toString() {
		return "(" + real + ", " + imag + ")";
	}


}
