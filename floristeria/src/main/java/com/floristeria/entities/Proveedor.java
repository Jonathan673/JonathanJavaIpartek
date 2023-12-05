package com.floristeria.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proveedor {
	private Long id;
	private String nombre;
	private String direccion;
	private Integer numeroTelefono;
	private String webSite;

	public Proveedor(String nombre, String direccion, Integer numeroTelefono, String webSite) {
		this(null, nombre, direccion, numeroTelefono, webSite);
	}
}
