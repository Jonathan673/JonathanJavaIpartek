package com.floristeria.presentation.backend.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;

import com.floristeria.entities.Producto;
import com.floristeria.entities.Proveedor;
import com.floristeria.globals.Global;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/gestion-proveedor")
public class AdminGestionProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);
			Proveedor proveedor = Global.AN.detalleProveedor(id);
			request.setAttribute("proveedor", proveedor);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/proveedor-nuevo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String web = request.getParameter("web");
		String numeroTelefono = request.getParameter("numeroTelefono");

		Long id = sId.trim().length() == 0 ? null : Long.parseLong(sId);
		Integer numero = numeroTelefono.trim().length() == 0 ? null : Integer.valueOf(numeroTelefono);

		Proveedor proveedor = new Proveedor(id, nombre, direccion, numero, web);
		
		if(proveedor.getId() != null) {
			Global.AN.modificarProveedor(proveedor);
		} else {
			Global.AN.insertarProveedor(proveedor);
		}
		
//		request.getRequestDispatcher("/admin/listado").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/listado-proveedores");
	}

}
