package com.zamazor.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto {
	// variables de instancia
	private Long id;
	private String nombre;
	private LocalDate fechaCaducidad;
	private BigDecimal precio;
	// Constructores
	public Producto(Long id, String nombre, LocalDate fechaCaducidad, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setFechaCaducidad(fechaCaducidad);
		setPrecio(precio);
	}
	public Producto(Producto producto) {
		this(producto.getId(), producto.getNombre(), producto.getFechaCaducidad(), producto.getPrecio());
	}

	public Producto(String nombre, LocalDate fechaCaducidad, BigDecimal precio) {
		this(null, nombre, fechaCaducidad, precio);
	}

	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, null, precio);
	}

	public Producto(String nombre) {
		this(null, nombre, null, BigDecimal.ZERO);
	}

	public Producto() {
		this(null, "Anónimo", null, BigDecimal.ZERO);
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
	public int hashCode() {
		return Objects.hash(fechaCaducidad, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(fechaCaducidad, other.fechaCaducidad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto: id=" + id + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad + ", precio=" + precio
				+ "]";
	}

}
