package com.ejercicio1.console.representation;

import java.util.Scanner;

import com.ejercicio1.entities.Empleado;

public class MainEjercicio7 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		int topeLista = 20;
		Empleado[] listaEmpleados;	
		
		Empleado empleado;
		String nif;
		int numeroEmpleados;
		String nombreEmpleado;
		double sueldoBase;
		int horasExtra;
		double irpf;
		String casado;
		int numeroHijos;
		int contador = 0;
		double importe;

		System.out.println("Indique el número de empleados que desea introducir (máximo 20): ");
		numeroEmpleados = sc.nextInt();
		while (numeroEmpleados > topeLista || numeroEmpleados < 1) {
			System.out.println("Introduzca una cantidad valida entre 1 y 20 empleados");
			numeroEmpleados = sc.nextInt();
		}
		topeLista = numeroEmpleados;
		listaEmpleados = new Empleado[topeLista];
		do {
			numeroEmpleados--;
			
			System.out.println("---Datos del nuevo empleado---");
			System.out.println("Indique el Nif del empleado: ");
			nif = sc.next();
			System.out.println("Indique el nombre del empleado: ");
			nombreEmpleado = sc.next();
			System.out.println("Indique el sueldo base del empleado: ");
			sueldoBase = sc.nextDouble();
			System.out.println("Indique las horas extra realizadas por el empleado");
			horasExtra = sc.nextInt();
			System.out.println("Indique el tipo de IRPF");
			irpf = sc.nextDouble();
			System.out.println("Indique si el empleado esta casado");
			casado = sc.next();
			System.out.println("Cuantos hijos tiene el empleado?");
			numeroHijos = sc.nextInt();
			

			empleado = new Empleado(nif);
			empleado.setNombre(nombreEmpleado);
			empleado.setSueldoBase(sueldoBase);
			empleado.setHorasExtraMes(horasExtra);
			empleado.setTipoIRPF(irpf);
			empleado.setCasado(casado);
			empleado.setNumeroHijos(numeroHijos);
			empleado.setImporteHorasExtra(importeHorasExtra());
			
			
			listaEmpleados[contador] = empleado;
			contador++;
			System.out.println("Empleado introducido");
		} while (numeroEmpleados > 0);

		System.out.println("Se han introducido todos los empleados");


		
		for(Empleado e:listaEmpleados) {
			System.out.println(e.Retenciones());
		}
	}

	private static double importeHorasExtra() {
		System.out.println("Cual es el importe de las horas extra?");
		
		return sc.nextDouble();
	}

}
