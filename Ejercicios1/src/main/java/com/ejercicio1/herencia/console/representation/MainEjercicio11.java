package com.ejercicio1.herencia.console.representation;

import com.ejercicio1.herencia.entities.Directivo;
import com.ejercicio1.herencia.entities.EmpleadoHerencia;
import com.ejercicio1.herencia.entities.Oficial;
import com.ejercicio1.herencia.entities.Operario;
import com.ejercicio1.herencia.entities.Tecnico;

public class MainEjercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoHerencia E1 = new EmpleadoHerencia("Facilito el tutorial");
		Directivo D1 = new Directivo("Mario");
		Operario OP1 = new Operario("Alfonso");
		Oficial OF1 = new Oficial("Luis");
		Tecnico T1 = new Tecnico("Pablo");
		System.out.println(E1);
		System.out.println(D1);
		System.out.println(OP1);
		System.out.println(OF1);
		System.out.println(T1);
		System.out.println(T1);
	}

}
