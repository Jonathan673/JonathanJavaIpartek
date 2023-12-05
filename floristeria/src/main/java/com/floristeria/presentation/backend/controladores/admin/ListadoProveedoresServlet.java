package com.floristeria.presentation.backend.controladores.admin;

import java.io.IOException;

import com.floristeria.globals.Global;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/listado-proveedores")
public class ListadoProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append(Global.UN.listadoProductos().toString());

		var proveedores = Global.AN.listadoProveedores();
		request.setAttribute("proveedores", proveedores);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listado-proveedores.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
