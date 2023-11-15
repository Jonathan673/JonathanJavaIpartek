<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.zamazor.logicanegocio.*, com.zamazor.accesodatos.*, com.zamazor.entidades.*, java.math.*, java.time.*"%>
<%!private static final UsuarioNegocio un = new UsuarioNegocioImplements();

	static {
		DaoProducto dao = new DaoProductoMemoria();

		dao.borrar(1L);
		dao.borrar(2L);
		dao.borrar(3L);
		dao.borrar(4L);

		dao.insertar(new Producto());
		dao.insertar(new Producto("Producto prueba"));
		dao.insertar(new Producto("Otro producto", new BigDecimal("1234.56")));
		dao.insertar(new Producto("Un producto más", LocalDate.of(2025, 1, 1), new BigDecimal("1234.56")));
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
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
			<%
			for (Producto p : un.listadoProductos()) {
			%>
			<tr>
				<th><a href="datos-producto.jsp?id=<%=p.getId()%>"><%=p.getId()%></a></th>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
				<td><%=p.getFechaCaducidad()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>