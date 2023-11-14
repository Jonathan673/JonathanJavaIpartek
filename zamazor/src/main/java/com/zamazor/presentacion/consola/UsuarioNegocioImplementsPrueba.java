package com.zamazor.presentacion.consola;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zamazor.accesodatos.DaoProducto;
import com.zamazor.accesodatos.DaoProductoMemoria;
import com.zamazor.entidades.Producto;
import com.zamazor.logicanegocio.UsuarioNegocio;
import com.zamazor.logicanegocio.UsuarioNegocioImplements;

public class UsuarioNegocioImplementsPrueba {

	public static void main(String[] args) {
		//dame todos los logs a partir del nivel info
		Logger.getLogger(UsuarioNegocioImplements.class.getName()).setLevel(Level.INFO);
		// Polimorfismo, declaramos lo mas generico pero instanciamos algo mas
		// especifico
		DaoProducto dao = new DaoProductoMemoria();

		dao.insertar(new Producto());
		dao.insertar(new Producto("Producto prueba"));
		dao.insertar(new Producto("Producto prueba", new BigDecimal("123.4")));
		dao.insertar(new Producto("Producto prueba", LocalDate.now(), new BigDecimal("123.4")));
		
		UsuarioNegocio negocio = new UsuarioNegocioImplements();
		
		for(Producto p: negocio.listadoProductos()) {
			System.out.println(p);
		}
		
		System.out.println("\n Listado por id");
		Producto producto = negocio.datosProducto(5L);
		System.out.println(producto);
	}
}
