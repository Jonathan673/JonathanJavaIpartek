package com.floristeria.entities;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "proveedores")
public class Proveedor {
	@Id
	private Long id;
	private String nombre;
	private String direccion;
	private Integer numeroTelefono;
	private String webSite;

	public Proveedor(String nombre, String direccion, Integer numeroTelefono, String webSite) {
		this(null, nombre, direccion, numeroTelefono, webSite);
	}
}
