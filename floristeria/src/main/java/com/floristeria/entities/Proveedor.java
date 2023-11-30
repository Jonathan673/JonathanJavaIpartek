package com.floristeria.entities;

import java.util.Objects;

public class Proveedor {
	private Long id;
	private String nombre;
	private String direccion;
	private Integer numeroTelefono;
	private String webSite;

	public Proveedor(Long id, String nombre, String direccion, Integer numeroTelefono, String webSite) {
		setId(id);
		setNombre(nombre);
		setDireccion(direccion);
		setNumeroTelefono(numeroTelefono);
		setWebSite(webSite);
	}

	public Proveedor(String nombre, String direccion, Integer numeroTelefono, String webSite) {
		this(null, nombre, direccion, numeroTelefono, webSite);
	}

	public Proveedor() {

	}

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, id, nombre, numeroTelefono, webSite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numeroTelefono, other.numeroTelefono)
				&& Objects.equals(webSite, other.webSite);
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", numeroTelefono="
				+ numeroTelefono + ", webSite=" + webSite + "]";
	}

}
