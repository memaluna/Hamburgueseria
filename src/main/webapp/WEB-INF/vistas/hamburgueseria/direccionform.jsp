<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
 		$(document).ready(function() {
			//$('#select-ingredientes').select2();
			$('#form-direccion').validate();
		}); 
	</script>

	<h1>Cargar nueva dirección</h1>
	<form:form method="post" action="/hamburgueseria/cliente/direccion/guardar" modelAttribute="direccionForm" id="form-direccion">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Calle</label>
			<form:input path="calle" cssClass="form-control required" />
			<form:errors path="calle" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Número</label>
			<form:input path="numero" cssClass="form-control required number" />
			<form:errors path="numero" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Localidad</label>
			<form:input path="localidad" cssClass="form-control required" />
			<form:errors path="localidad" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Provincia</label>
			<form:input path="provincia" cssClass="form-control required" />
			<form:errors path="provincia" cssClass="error"/>
		</div>
				<div class="form-group">
			<label>País</label>
			<form:input path="pais" cssClass="form-control required" />
			<form:errors path="pais" cssClass="error"/>
		</div>
		<div class="form-group" readonly="true"><!-- hidden="true" -->
			<label>Cliente</label>
			<form:input path="cliente" cssClass="form-control required" />
			<form:errors path="cliente" cssClass="error"/>
		</div>
		
		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>