<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de clientes</h1>

<script type="text/javascript">
	$(document).ready(function() {
		$('.btn-borrar').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Borramos la hamburguesa?", function(result){ 
				if(result) {
					window.location = hrefOriginal;
				}
			});
			
		});
	});	
</script>
<table class="table table-striped table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Teléfono</th>
			<th>Direcciones</th>
			<th>Email</th>
			<th>Fecha de alta</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${clientes}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.nombre}</td>
			<td>${p.apellido}</td>
			<td>${p.telefono}</td>
			
			<td>			
				<c:forEach items="${p.direcciones}" var="v" varStatus="status">
					<span class="badge bg-warning">${v.calle} ${v.numero} - ${v.barrio}</span>
				</c:forEach>
			</td>

			
			
			<td>${p.email}</td>
			<td>${p.fechaAlta}</td>
			<td>
				<a href="/hamburgueseria/cliente/${p.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/hamburgueseria/cliente/${p.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/hamburgueseria/cliente/${p.id}/borrar" class="btn btn-danger btn-borrar">Borrar</a>
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>