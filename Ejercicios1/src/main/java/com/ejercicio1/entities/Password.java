package com.ejercicio1.entities;

import java.util.Random;
import java.util.Scanner;

public class Password {
	private String contraseña;

    //Constructor por defecto
    //Crea una contraseña aleatoria de longitud 8
    //Para obtener la contraseña invoca al constructor con parámetros y le envía la longitud
    public Password() {
        this(8);
    }

    //Constructor con parámetros
    //Crea una contraseña aleatoria con una longitud que recibe como parámetro
    public Password(int longitud) {
        contraseña = generaPassword(longitud);
    }

    //Método get
    public String getContraseña() {
        return contraseña;
    }
    
    //Esta clase no tendrá método set para la contraseña. 
    //El valor de la contraseña solo se puede cambiar mediante el método modificarContraseña

    //Método que genera las contraseñas aleatorias
    //Se trata de un método privado para que no pueda ser invicado desde fuera de lal clase
    private String generaPassword(int longitud) {
        Random rnd = new Random();
        StringBuilder password = new StringBuilder();
        char caracter;
        int digito;
        for (int i = 0; i < longitud; i++) {
            //Se obtiene un número al azar del 0 al 4. 
            //Según este número se obtiene una mayúscula, minúscula, número, punto o guión bajo
            switch (rnd.nextInt(5)) {
                case 0:
                    caracter = (char) (rnd.nextInt('Z' - 'A' + 1) + 'A');//obtenemos una mayúscula al azar
                    password.append(caracter);
                    break;
                case 1:
                    caracter = (char) (rnd.nextInt('z' - 'a' + 1) + 'a'); //obtenemos una minúscula al azar       
                    password.append(caracter);
                    break;
                case 2:
                    digito = rnd.nextInt(10); //obtenemos un dígito del 0 al 9
                    password.append(digito);
                    break;
                case 3:
                    password.append('.'); //añadimos un punto
                    break;
                case 4:
                    password.append('_'); //añadimos un guión bajo
                    break;
            }
        }
        return password.toString();
    }

    //Método que comprueba si la contraseña es fuerte o no
    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int digitos = 0;
        int puntos = 0;
        int guiones = 0;
        if (contraseña.length() < 8) {
            return false;
        }
        for (int i = 0; i < contraseña.length(); i++) {
            if (contraseña.charAt(i) >= 'a' && contraseña.charAt(i) <= 'z') {
                minusculas++;
            } else if (contraseña.charAt(i) >= 'A' && contraseña.charAt(i) <= 'Z') {
                mayusculas++;
            } else if (contraseña.charAt(i) >= '0' && contraseña.charAt(i) <= '9') {
                digitos++;
            } else if (contraseña.charAt(i) == '.') {
                puntos++;
            } else if (contraseña.charAt(i) == '_') {
                guiones++;
            }
        }

        if (mayusculas >= 2 && minusculas >= 2 && digitos >= 1 && puntos >= 1 && guiones >= 1) {
            return true;
        }
        return false;
    }
    
    //método para modificar una contraseña
    //Se introduce una contraseña por teclado
    //si la contraseña introducida es fuerte se modifica la contraseña actual
    //Si no es fuerte, la contraseña actual no se modifica
    public boolean modificarContraseña(){
        Scanner sc = new Scanner(System.in);
        String cadena = contraseña; //guardamos la contraseña actual
        System.out.println("Modificar la contraseña");
        System.out.print("Introduzca nueva contraseña: ");
        contraseña = sc.nextLine();
        sc.close();
        if(esFuerte()){
            return true;
        }
        contraseña = cadena; //si no es fuerte recuperamos la contraseña original
        return false;
    }
}
