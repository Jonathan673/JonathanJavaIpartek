package com.ejercicio1.console.representation;

import java.util.Scanner;

import com.ejercicio1.herencia.entities.Empleado;

public class MainEjercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Empleado empleado;
		int numeroEmpleados;
		String nombreEmpleado;
		double sueldoBase;
		int horasExtra;
		double irpf;
		boolean casado;
		int numeroHijos;
		
		System.out.println("Indique el número de empleados que desea introducir (máximo 20): ");
		numeroEmpleados = sc.nextInt();
		while(numeroEmpleados>20||numeroEmpleados<1) {
			System.out.println("Introduzca una cantidad valida entre 1 y 20 empleados");
			numeroEmpleados = sc.nextInt();
		}
		do {
			System.out.println("Indique el Nif del empleado: ");
			empleado = new Empleado(sc.nextLine());
			System.out.println("Indique el nombre del empleado: ");
			nombreEmpleado = sc.nextLine();
			System.out.println("Indique el sueldo base del empleado: ");
			sueldoBase = sc.nextDouble();
			System.out.println("Indique las horas extra realizadas por el empleado");
			horasExtra = sc.nextInt();
			System.out.println("Indique el tipo de IRPF");
			irpf = sc.nextDouble();
			System.out.println("Indique si el empleado esta casado");
			casado = sc.hasNext();//cuidado
			System.out.println("Cuantos hijos tiene el empleado?");
			numeroHijos = sc.nextInt();
			
			
			
			numeroEmpleados--;
		}while(numeroEmpleados >=0);
	}

}
