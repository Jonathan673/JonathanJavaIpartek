package com.ejercicio1.entities;

public class Empleado {
	// Variables
	private String nif;
	private String nombre;
	private double sueldoBase;
	private int horasExtraMes;
	private double tipoIRPF;
	private boolean casado;
	private int numeroHijos;
	private static double importeHorasExtra;

	// constructores
	public Empleado(String nif) {
		setNif(nif);
	}

	public Empleado() {

	}

	// getters and setters
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getHorasExtraMes() {
		return horasExtraMes;
	}

	public void setHorasExtraMes(int horasExtraMes) {
		this.horasExtraMes = horasExtraMes;
	}

	public double getTipoIRPF() {
		return tipoIRPF;
	}

	public void setTipoIRPF(double tipoIRPF) {
		this.tipoIRPF = tipoIRPF;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public static double getImporteHorasExtra() {
		return importeHorasExtra;
	}

	public static void setImporteHorasExtra(double importeHorasExtra) {
		Empleado.importeHorasExtra = importeHorasExtra;
	}

	// metodos
	public double SueldoHorasExtra() {
		double sueldoExtra = importeHorasExtra * horasExtraMes;
		return sueldoExtra;
	}

	public double SueldoBruto() {
		return SueldoHorasExtra() + sueldoBase;

	}

	public double Retenciones() {
		if (casado) {
			setTipoIRPF(this.tipoIRPF - 2);
		}
		if (numeroHijos > 0) {
			setTipoIRPF(this.tipoIRPF - numeroHijos);
		}
		double retenciones;
		retenciones = (SueldoBruto()*tipoIRPF)/100;
		return retenciones;
	}

	// toString
	@Override
	public String toString() {
//		return "Empleado [nif=" + nif + ", nombre=" + nombre + ", sueldoBase=" + sueldoBase + ", horasExtraMes="
//				+ horasExtraMes + ", tipoIRPF=" + tipoIRPF + ", casado=" + casado + ", numeroHijos=" + numeroHijos
//				+ "]";
		StringBuilder sb = new StringBuilder();
		sb.append(nif +" "+ nombre);
		sb.append("Sueldo Base: "+ sueldoBase);
		sb.append("Horas Extras: "+ horasExtraMes);
		if(casado) {
			sb.append("Si");
		}else {
			sb.append("No");
		}
		sb.append("Número de Hijos: "+ numeroHijos);
		return sb.toString();
	}

}
