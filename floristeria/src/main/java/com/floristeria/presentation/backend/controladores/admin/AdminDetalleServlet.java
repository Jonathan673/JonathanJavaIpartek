package com.floristeria.presentation.backend.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;

import com.floristeria.entities.Producto;
import com.floristeria.globals.Global;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/detalle")
public class AdminDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);
			Producto producto = Global.AN.detalleProducto(id);
			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/admin-detalle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String tipo_producto = request.getParameter("productTipe");
		String sPrecio = request.getParameter("precio");
		String sUnidades = request.getParameter("unidades");

		Long id = sId.trim().length() == 0 ? null : Long.parseLong(sId);
		BigDecimal precio = new BigDecimal(sPrecio);
		Integer unidades = sUnidades.trim().length() == 0 ? null : Integer.valueOf(sUnidades);

		Producto producto = new Producto(id, nombre, tipo_producto, precio, unidades);
		
		if(producto.getId() != null) {
			Global.AN.modificarProducto(producto);
		} else {
			Global.AN.insertarProducto(producto);
		}
		
//		request.getRequestDispatcher("/admin/listado").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}

}
