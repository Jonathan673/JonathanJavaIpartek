package com.zamazor.presentacion.consola;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.zamazor.accesodatos.DaoProducto;
import com.zamazor.accesodatos.DaoProductoMemoria;
import com.zamazor.entidades.Producto;
import com.zamazor.logicanegocio.UsuarioNegocio;
import com.zamazor.logicanegocio.UsuarioNegocioImplements;

public class PresentacionConsola {

		static {
			DaoProducto dao = new DaoProductoMemoria();
			
			dao.insertar(new Producto());
			dao.insertar(new Producto("Producto prueba"));
			dao.insertar(new Producto("Otro producto", new BigDecimal("1234.56")));
			dao.insertar(new Producto("Un producto más", LocalDate.of(2025, 1, 1), new BigDecimal("1234.56")));
		}
		
		private static final int SALIR = 0;

		private static final Scanner SC = new Scanner(System.in);
		
		private static final UsuarioNegocio un = new UsuarioNegocioImplements();

		public static void main(String[] args) {
			int opcion;

			do {
				menu();
				opcion = pedirOpcion();
				procesarOpcion(opcion);
			} while (opcion != SALIR);
		}

		private static void menu() {
			System.out.println("1. Listado");
			System.out.println("2. Datos producto");
			System.out.println("0. Salir");
		}

		private static int pedirOpcion() {
			System.out.print("Dime la opción que deseas: ");
			return SC.nextInt();
		}

		private static void procesarOpcion(int opcion) {
			switch (opcion) {
			case 1:
				listado();
				break;
			case 2:
				datosProducto();
				break;
			case 0:
				System.out.println("Hasta otra");
				break;
			default:
				System.out.println("No conozco esa opción");
			}
		}

		private static void listado() {
			for(Producto p: un.listadoProductos()) {
				mostrarProductoLinea(p);
			}
		}

		private static void mostrarProductoLinea(Producto p) {
			System.out.println(p);
		}

		private static void datosProducto() {
			System.out.print("Dime el ID del producto: ");
			Long id = SC.nextLong();
			
			Producto p = un.datosProducto(id);
			
			System.out.printf(
					"""
					Id: %s
					Nombre: %s
					Precio: %s
					Fecha de Caducidad: %s
					""", p.getId(), p.getNombre(), p.getPrecio(), p.getFechaCaducidad());
		}

}
