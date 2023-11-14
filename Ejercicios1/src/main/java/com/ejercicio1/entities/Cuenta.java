package com.ejercicio1.entities;

public class Cuenta {
	// metodos ingreso, reintegro, transferencia
	// construcctor por defecto, con parametros, copia
	// getters and setters
	// Variables
	private String nombreCliente;
	private String numeroCuenta;
	private Double tipoInteres;// Cambiar a BigDecimal
	private Double saldo;// Cambiar a BigDecimal
	// Constructor con parámetros

	public Cuenta(String nombre, String numeroCuenta, Double tipoInteres, Double saldo) {
		setNombreCliente(nombre);
		setNumeroCuenta(numeroCuenta);
		setTipoInteres(tipoInteres);
		setSaldo(saldo);
	}

	// constructor por defecto
	public Cuenta() {

	}

	// constructor copia
	public Cuenta(Cuenta cuenta) {
		this(cuenta.getNombreCliente(), cuenta.getNumeroCuenta(), cuenta.getTipoInteres(), cuenta.getSaldo());
	}

	// getters and setters
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombre) {
		this.nombreCliente = nombre;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(Double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void ingreso(Double ingreso) {
		if (ingreso <= 0 || ingreso == null) {
			throw new RuntimeException("No se pueden ingresar cantidades iguales o menores a 0.");
		}
		double dinero;
		dinero = this.getSaldo() + ingreso;
		this.setSaldo(dinero);
	}

	public void reintegro(Double reintegro) {
		if (this.saldo <= 0 || this.saldo < reintegro) {
			throw new RuntimeException("No hay suficiente dinero en la cuenta de " + getNombreCliente());
		}
		this.setSaldo(this.saldo -= reintegro);
	}

	public void transferencia(Cuenta cuenta, Double cantidad) {
		if (cantidad <= 0) {
			throw new RuntimeException("No se puede ingresar una cantidad menor o igual a 0");
		}
		reintegro(cantidad);
		cuenta.setSaldo(cuenta.saldo += cantidad);
	}
}
