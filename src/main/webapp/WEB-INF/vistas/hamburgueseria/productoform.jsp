<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
	$(document).ready(function() {
		$('#select-ingredientes').select2({
			theme: 'bootstrap4',
		});
		//$('#form-producto').validate();
	});
	</script>

	<h1>Cargar/Modificar Producto</h1>

	<form:form method="post" action="/hamburgueseria/producto/guardar" modelAttribute="productoForm" id="form-hamburguesa">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>

		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Ingredientes</label>
			<form:input path="ingredientes" cssClass="form-control required" />
			<form:errors path="ingredientes" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control required number" />
			<form:errors path="precio" cssClass="error"/>
		</div>

		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
