package com.floristeria.entities;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
	private Long id;
	private String nombre;
	private String productTipe;
	private BigDecimal precio;
	private Integer unidades;
	
	//Constructor propio
	public Producto(String nombre, String tipoProducto, BigDecimal precio, Integer unidades) {
		this(null, nombre, tipoProducto, precio, unidades);
	}

	//Getters and setters propios
	public void setUnidades(Integer unidades) {
		if (unidades <= 0 || unidades == null) {
			this.unidades = 0;
			return;
		}
		this.unidades = unidades;
	}

	public void setProductTipe(String tipoProducto) {
		if (tipoProducto == null) {
			tipoProducto = "Complemento";
		}
		this.productTipe = tipoProducto;
	}

	// HashCode y equals propios
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

}
