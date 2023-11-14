package com.ejercicio1.console.representation;

import com.ejercicio1.entities.Nif;

public class MainEjercicio8 {

	public static void main(String[] args) {
        Nif nif1 = new Nif();
        nif1.leer();
        System.out.println(nif1);

        Nif nif2 = new Nif(12345677);
        System.out.println(nif2);

	}

}
