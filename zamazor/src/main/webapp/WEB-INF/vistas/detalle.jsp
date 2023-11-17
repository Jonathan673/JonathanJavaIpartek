<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.zamazor.entidades.Producto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de producto</title>
</head>
<body>
	<dl>
		<dt>Id</dt>
		<dd>${producto.id}</dd>
		<dt>Nombre</dt>
		<dd>${producto.nombre}</dd>
		<dt>Precio</dt>
		<dd>${producto.precio}</dd>
		<dt>Fecha de caducidad</dt>
		<dd>${producto.fechaCaducidad}</dd>
	</dl>
</body>
</html>