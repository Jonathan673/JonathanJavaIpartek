package com.zamazor.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;



public class Producto {
	// variables de instancia
	private Long id;
	private String nombre;
	private LocalDate fechaCaducidad;
	private BigDecimal precio;

	// Constructor
	public Producto(Long id, String nombre, LocalDate fechaCaducidad, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setFechaCaducidad(fechaCaducidad);
		setPrecio(precio);
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id <= 0) {
			throw new RuntimeException("No se admiten ids inferiores a 1");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres vacíos o nulos");
		}
		this.nombre = nombre;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		if (fechaCaducidad != null && fechaCaducidad.isBefore(LocalDate.now())) {
			throw new RuntimeException("Fecha incorrecta");
		}
		this.fechaCaducidad = fechaCaducidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			throw new RuntimeException("Precio obligatorio que no sea menos que cero");
		}
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto: id=" + id + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad + ", precio=" + precio
				+ "]";
	}

}
