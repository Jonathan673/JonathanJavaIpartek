package com.ejercicio1.console.representation;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEjercicio10 {

	// se crea el ArrayList de Personas
	static ArrayList personas = new ArrayList();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        //se leen las personas y se introducen en el ArrayList
        LeerPersonas();
        if (NumeroDePersonas() > 0) {
            //se muestran todas las personas introducidas
            System.out.println("\nPersonas introducidas: ");
            Mostrar();
            //se muestra la persona de mayor edad
            System.out.println("\nPersona de mayor edad: ");
            System.out.println(PersonaMayorEdad());
            //se muestran todas las personas que viven en Elche
            System.out.println("\nNúmero de personas que viven en Elche: "
                                          + CuantasPersonasVivenEn("Elche"));                                     
            //se muestra el número de personas mayores de edad
            System.out.println("\nNúmero de personas mayores de edad : "
                                          + personasMayoresDeEdad());         
        }
    }
	private static String personasMayoresDeEdad() {
		// TODO Auto-generated method stub
		return null;
	}
	private static String CuantasPersonasVivenEn(String nombreCiudad) {
		// TODO Auto-generated method stub
		return null;
	}
	private static char[] PersonaMayorEdad() {
		// TODO Auto-generated method stub
		return null;
	}
	private static int NumeroDePersonas() {
		// TODO Auto-generated method stub
		return 0;
	}
	private static void LeerPersonas() {
		// TODO Auto-generated method stub
		
	}
	// Resto de métodos
	private static void Mostrar() {
		// TODO Auto-generated method stub
		
	}

}
