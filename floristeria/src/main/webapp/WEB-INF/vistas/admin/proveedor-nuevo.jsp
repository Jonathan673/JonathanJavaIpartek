<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/admin-cabecera.jsp"%>

<main class="container">
<h1>Nuevo Proveedor</h1>
	<form action="admin/gestion-proveedor" method="post">
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm">
				<input type="number" type="hidden" readonly class="form-control" id="id" name="id"
					value="${proveedor.id}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text" class="form-control" id="nombre" name="nombre"
					value="${proveedor.nombre}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="numeroTelefono" class="col-sm-2 col-form-label">Número
				de teléfono</label>
			<div class="col-sm">
				<input type="number" step=".01" class="form-control"
					id="numeroTelefono" name="numeroTelefono"
					value="${proveedor.numeroTelefono}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="direccion" class="col-sm-2 col-form-label">Dirección</label>
			<div class="col-sm">
				<input type="text" class="form-control" id="direccion"
					name="direccion" value="${proveedor.direccion}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="web" class="col-sm-2 col-form-label">Página Web</label>
			<div class="col-sm">
				<input type="text" class="form-control" id="web" name="web"
					value="${proveedor.webSite}">
			</div>
		</div>

		<div class="row mb-3">
			<div class="offset-sm-2 col-sm">
				<button type="submit" class="btn btn-primary">Guardar</button>
				<button type="reset" class="btn btn-warning">Restaurar
					valores originales</button>
				<!-- <a class="btn btn-danger" href="admin/gestion-proveedor">Vaciar formulario</a> -->
			</div>
		</div>
	</form>

</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
