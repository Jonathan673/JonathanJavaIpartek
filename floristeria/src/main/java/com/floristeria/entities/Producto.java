package com.floristeria.entities;

import java.math.BigDecimal;
import java.util.Objects;

import com.floristeria.enumlists.ProductTipe;

public class Producto {
	// productos que estarán disponibles en la floristeria, necesita un id, nombre,
	// unidades disponibles y tipo de producto (flor artificial,
	// complemento tipo maceta...), precio
	private Long id;
	private String nombre;
	private String productTipe;
	private BigDecimal precio;
	private Integer unidades;

	
	//Constructores
	public Producto(long id, String nombre, String tipoProducto, BigDecimal precio, Integer unidades) {
		setId(id);
		setNombre(nombre);
		setProductTipe(tipoProducto);
		setPrecio(precio);
		setUnidades(unidades);
	}

	public Producto() {
		
	}
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		if(unidades<=0 || unidades == null) {
			this.unidades = 0;
			return;
		}
		this.unidades = unidades;
	}

	public String getProductTipe() {
		return productTipe;
	}

	public void setProductTipe(String tipoProducto) {
		this.productTipe = tipoProducto;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	//HashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, productTipe);
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
		return id == other.id && Objects.equals(nombre, other.nombre) && productTipe == other.productTipe;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", unidades=" + unidades + ", productTipe=" + productTipe
				+ ", precio=" + precio + "]";
	}
}
