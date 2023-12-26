package com.inmobiliariaPruebaSpring.presentacion;

import com.inmobiliariaPruebaSpring.accesodatos.DaoEstablecimientoJdbc;

public class PresentacionConsola {

	public static void main(String[] args) {
		DaoEstablecimientoJdbc dao = new DaoEstablecimientoJdbc(null);
		
		
		System.out.println(dao.obtenerTodos());
	}

}
