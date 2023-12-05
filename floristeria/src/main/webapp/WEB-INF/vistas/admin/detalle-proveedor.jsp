<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container">

	<div class="card mb-3">
		<div class="row g-0">
			<div class="col-md-4">
				<img src="https://picsum.photos/300/500"
					class="img-fluid rounded-start" alt="...">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">${proveedor.nombre}</h5>
					<div class="card">
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><span>Dirección: </span>${proveedor.direccion}</li>
							<li class="list-group-item"><span>Página Web: </span>${proveedor.webSite}</li>
						</ul>
					</div>
					<p class="card-text">
						<small class="text-body-secondary"><span>Tf: </span>${proveedor.numeroTelefono}</small>
					</p>
					<a class="btn btn-sm btn-primary" href="admin/gestion-proveedor?id=${proveedor.id}">Editar</a>
					<a
						onclick="return confirm('¿Estás seguro de borrar el proveedor ${proveedor.nombre}?')"
						class="btn btn-sm btn-danger" href="admin/borrar-proveedor?id=${proveedor.id}">Eliminar Proveedor</a>

				</div>
				<a class="btn btn-secondary" href="admin/listado-proveedores">Volver
					al listado</a>
			</div>
		</div>
	</div>

</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
