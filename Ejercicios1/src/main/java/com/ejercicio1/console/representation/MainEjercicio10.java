package com.ejercicio1.console.representation;

import java.util.ArrayList;
import java.util.Scanner;

import com.ejercicio1.entities.Fecha;
import com.ejercicio1.entities.Persona;

public class MainEjercicio10 {

	// se crea el ArrayList de Personas
	static ArrayList<Persona> personas = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        //se leen las personas y se introducen en el ArrayList
        LeerPersonas();
//        if (NumeroDePersonas() > 0) {
//            //se muestran todas las personas introducidas
//            System.out.println("\nPersonas introducidas: ");
//            Mostrar();
//            //se muestra la persona de mayor edad
//            System.out.println("\nPersona de mayor edad: ");
//            System.out.println(PersonaMayorEdad());
//            //se muestran todas las personas que viven en Elche
//            System.out.println("\nNúmero de personas que viven en Elche: "
//                                          + CuantasPersonasVivenEn("Elche"));                                     
//            //se muestra el número de personas mayores de edad
//            System.out.println("\nNúmero de personas mayores de edad : "
//                                          + personasMayoresDeEdad());         
//        }
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
		int contador = 0;
		int indice = 0;
		Persona persona;
		Fecha fecha;
		int codPostal;
		String nombre,calle,ciudad;

		
		System.out.println("Cuantas personas desea introducir? ");
		while(contador <= 0) {
			contador = sc.nextInt();
		}

		do {
			System.out.println("Introduzca el dia en el que nació");
			fecha = new Fecha();
			fecha.setDia(sc.nextInt());
			System.out.println("Introduzca el mes en el que nació");
			fecha.setMes(sc.nextInt());
			System.out.println("Introduzca el año en el que nació");
			fecha.setAño(sc.nextInt());
			System.out.println("Introduzca el nombre de la persona");
			nombre = sc.next();
			System.out.println("Introduzca el nombre de la calle en la que vive");
			calle = sc.next();
			System.out.println("Introduzca el código portal");
			codPostal = sc.nextInt();
			System.out.println("Introduzca el nombre de la ciudad en la que vive");
			ciudad = sc.next();
			persona = new Persona(nombre, calle, codPostal, ciudad, fecha);
			
			personas.add(persona);
			System.out.println("Datos introducidos y almacenados correctamente");
			
			indice++;
			
		}while(contador>0);
		
		for(Persona p:personas) {
			System.out.println(p);
		}
		
		System.out.println(persona);
		System.out.println(fecha);
	}
	// Resto de métodos
	private static void Mostrar() {
		// TODO Auto-generated method stub
		
	}

}
