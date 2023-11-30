<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container">

	<%-- <ul>
		<c:forEach items="${productos}" var="p">
			<li>${p}</li>
		</c:forEach>
	</ul> --%>
<h1>Proveedores</h1>
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${proveedores}" var="p">
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/300/200?${p.id}"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${p.nombre}</h5>
						<ul class="list-group list-group-flush">
							<%-- <li class="list-group-item">${p.direccion}</li>
							<li class="list-group-item">${p.numeroTelefono}</li> --%>
						</ul>
						<a class="btn btn-primary w-100 stretched-link" href="detalle?id=${p.id}">Ver detalle</a>
					</div>
					<div class="card-footer">
						<%-- <small class="text-body-secondary">${p.productTipe}</small> --%>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
