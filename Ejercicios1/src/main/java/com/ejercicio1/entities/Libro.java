package com.ejercicio1.entities;

public class Libro {	
	/**
	 * Variables de la entidad Libro
	 */
	private String titulo;
	private String autor;
	private int ejemplares;
	private int ejemplaresPrestados;
	/**
	 * Constructor con parametros de la entidad Libro()
	 * @param titulo
	 * @param autor
	 * @param ejemplares
	 * @param ejemplaresPrestados
	 */
	public Libro(String titulo, String autor, int ejemplares, int ejemplaresPrestados) {
		setTitulo(titulo);
		setAutor(autor);
		setEjemplares(ejemplares);
		setEjemplaresPrestados(ejemplaresPrestados);
	}
	/**
	 * Constructor vacio de la clase Libro
	 */
	public Libro() {
		
	}
	//Getters and setters
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	public int getEjemplaresPrestados() {
		return ejemplaresPrestados;
	}
	public void setEjemplaresPrestados(int ejemplaresPrestados) {
		this.ejemplaresPrestados = ejemplaresPrestados;
	}
	/**
	 * Metodo Prestamo, devuelve true o false en funcion a si hay libros que prestar.
	 * @param libro
	 * @return hayLibros
	 */
	public boolean Prestamo(Libro libro) {
		boolean hayLibros = false;
		if(this.ejemplares <= 0) {
			hayLibros = false;
			//throw new RuntimeException("No queda ningun libro");
		}else {
			ejemplaresPrestados++;
			ejemplares--;
			hayLibros = true;
		}
		return hayLibros;
	}
	/**
	 * Metodo Devoluciones, devuelve true o false en funcion a los ejemplares prestados
	 * @param libro
	 * @return
	 */
	public boolean Devoluciones(Libro libro) {
		boolean libroPrestados = false;
		if(this.ejemplaresPrestados <= 0) {
			libroPrestados = false;
			//throw new RuntimeException("No se ha restado ningun libro de este tipo");
		}else {
			ejemplaresPrestados--;
			ejemplares++;
			libroPrestados = true;
		}
		return libroPrestados;
	}
	/**
	 * Metodo toString()
	 */
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ejemplares=" + ejemplares + ", ejemplaresPrestados="
				+ ejemplaresPrestados + "]";
	}
}
