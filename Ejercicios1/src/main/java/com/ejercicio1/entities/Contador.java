package com.ejercicio1.entities;

public class Contador {
	//variables
	private int cont;
	//constructores

	public Contador(int cont) {
		this.setCont(cont);
	}
	public Contador() {
		
	}
	public Contador(Contador contador) {
		this(contador.getCont());
	}
	
	//getters and setters
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		if(cont < 0) {
			cont = 0;
		}
		this.cont = cont;
	}
	public void incrementar() {
		cont ++; 
	}
	public void decrementar() {
		cont--;
		if(cont <= 0) 
			cont = 0;

	}
}
