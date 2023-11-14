package com.ejercicio1.entities;

public class Fraccion {
	// variables
	private int num;
	private int den = 1;

	// constructor con parametros
	public Fraccion(int num, int den) {
		setNum(num);
		setDen(den);
	}

	public Fraccion(Fraccion fraccion) {
		this(fraccion.getNum(), fraccion.getDen());
	}

	// constructor con un parametro
	public Fraccion(int num) {
		this(num, 1);
	}

	// constructor vacio
	public Fraccion() {

	}

	// getters and setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDen() {
		return den;
	}

	// por defecto den sera 1 siempre
	public void setDen(int den) {
		if (den <= 0) {
			den = 1;
		}
		this.den = den;
	}

	// metodos
    //sumar fracciones
    public Fraccion Sumar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den + this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla                                                   
        return aux;
    }
   
    //restar fracciones
    public Fraccion Restar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den - this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
   
    //multiplicar fracciones
    public Fraccion Multiplicar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //dividir fracciones
    public Fraccion Dividir(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den;
        aux.den = this.den * f.num;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

	// Cálculo del máximo común divisor
	private int mcd() {
		int u = Math.abs(num);
		int v = Math.abs(den);
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}
    //método para simplificar fracciones
    private void simplificar() {
        int n = mcd(); //se calcula el mcd de la fracción
        num = num / n;
        den = den / n;
    }

	@Override
	public String toString() {
		return num + "/" + den;
	}
}
