package com.zamazor.presentacion.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.zamazor.accesodatos.DaoProducto;
import com.zamazor.accesodatos.DaoProductoMemoria;
import com.zamazor.entidades.Producto;
import com.zamazor.logicanegocio.UsuarioNegocio;
import com.zamazor.logicanegocio.UsuarioNegocioImplements;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final UsuarioNegocio un = new UsuarioNegocioImplements(); 
	
	static {
		DaoProducto dao = new DaoProductoMemoria();
		
		dao.insertar(new Producto());
		dao.insertar(new Producto("Producto prueba"));
		dao.insertar(new Producto("Otro producto", new BigDecimal("1234.56")));
		dao.insertar(new Producto("Un producto más", LocalDate.of(2025, 1, 1), new BigDecimal("1234.56")));
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		out.println(
				"""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Productos</title>
				</head>
				<body>
					<table>
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Precio</th>
								<th>Fecha de caducidad</th>
							</tr>
						</thead>
						<tbody>
				""");
		
		for(Producto p: un.listadoProductos()) {
			out.printf("<tr><th><a href='datos-producto?id=%1$s'>%s</a></th><td>%s</td><td>%s</td><td>%s</td></tr>", 
					p.getId(), p.getNombre(), p.getPrecio(), p.getFechaCaducidad());
		}
		
		out.println(
				"""
				</tbody>
				</table>
				</body>
				</html>
				""");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}