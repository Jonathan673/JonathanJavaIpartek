package com.ejercicio1.console.representation;

import com.ejercicio1.entities.Fraccion;

public class MainEjercicio4 {

	public static void main(String[] args) {
	    // Se crean 4 fracciones
        Fraccion f1 = new Fraccion(1, 4); // Fracción 1/4
        Fraccion f2 = new Fraccion(1, 2); // Fracción 1/2
        Fraccion f3 = new Fraccion(); // Fracción 0/1
        Fraccion f4 = new Fraccion(4); // Fracción 4/1
        
        
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        
        
        
        // operaciones aritméticas con esas fracciones
        Fraccion suma = f1.Sumar(f2);
        Fraccion resta = f1.Restar(f3);
        Fraccion producto = f1.Multiplicar(f4);
        Fraccion cociente = f1.Dividir(f2);
        //mostrar resultados
        System.out.println(f1 + " + " + f2 + " = " + suma);
        System.out.println(f1 + " - " + f3 + " = " + resta);
        System.out.println(f1 + " * " + f4 + " = " + producto);
        System.out.println(f1 + " / " + f2 + " = " + cociente);  
	}

}
