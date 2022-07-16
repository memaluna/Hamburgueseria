<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
 		$(document).ready(function() {
 			moment.locale('es');
			//$('#select-hamburguesas').select2();			
			$('#select-clientes').select2({
				theme: 'bootstrap4'
			});
			$('#form-pedido').validate();
			$("#entregadoCB").click(function() { return false; });
			
			//logica para extraer direccion asociada a cliente
			$('#select-clientes').on('change', function (e) {
			    var optionSelected = $("option:selected", this);
			    var valueSelected = this.value;
			    console.log(valueSelected);
			    if(valueSelected != ""){
				    $.ajax({
				        url: "http://localhost:8080/api/hamburguesas/cliente/" + this.value
				    }).then(function(data) {
				       $("#direccion").val(data.direccion);
				    });
			    }else{
			    	$("#direccion").val("");
			    }
			});
			
			
			 //logica para agregar y quitar hamburguesas a lista de compras.
			$("#btn-agregar").click(function() {				
				var o = new Option($('#select-hamburguesas option').filter(':selected').text(), $('#select-hamburguesas option').filter(':selected').val());
				$(o).html($('#select-hamburguesas option').filter(':selected').text());
				$("#select-lista").append(o);			
			});
			$("#btn-quitar").click(function() {				
				$('option:selected', "#select-lista").remove();
			});
			//logica para sumar precio a importe total
			$("#select-lista").bind("DOMSubtreeModified", function() {
	 			let precio = 0;
				$("#select-lista > option").each(function() {
					
					//console.log(this.value)
					$.ajax({
				        url: "http://localhost:8080/api/hamburguesas/hamburguesa/" + this.value
				    }).then(function(data) {
				       //console.log(data.precio.precio)
				       precio = precio + data.precio;
				       $("#importe").val(precio);
				    });
				
			    });
				if($("#select-lista").children().length <= 0){
					$("#importe").val(0);
				}
			});
			
			//Cargar fecha de pedido
			$("#fecha-pedido").val(moment().format("DD-MM-YYYY hh:mm:ss"));
			//Cargar hamburguesas
			
			$.ajax({
		        url: "http://localhost:8080/api/hamburguesas/"
		    }).then(function(data) {
		       console.log(data)
		       $.each(data, function(id, nombre) {
			       console.log(nombre.id)
		    	   $("#select-hamburguesas").append('<option value=' + nombre.id + '>' + nombre.nombre + '</option>');
		    	    });
		    });
			
			//Cargar clientes
			
			$.ajax({
		        url: "http://localhost:8080/api/hamburguesas/clientes/"
		    }).then(function(data) {
		       console.log(data)
		       $.each(data, function(id, nombre) {
			       console.log(nombre.id)
		    	   $("#select-clientes").append('<option value=' + nombre.id + '>' + nombre.nombre + '</option>');
		    	    });
		    });
			
		}); 
 		
	</script>

	<h1>Cargar nuevo pedido</h1>
	<form:form method="post" action="/hamburguesas/pedido/guardar" modelAttribute="pedidoForm" id="form-pedido">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Cliente</label>
			<form:select path="cliente" cssClass="form-control" id="select-clientes" />
		</div>
		<div class="form-group">
			<label>Dirección de entrega</label>
			<form:input path="direccionEntrega" cssClass="form-control required" id="direccion"/>
			<form:errors path="direccionEntrega" cssClass="error"/>
		</div>
		<div class="form-group d-flex justify-content-center d-flex align-items-center" >
			<div class="col-sm-3">
				<label>Hamburguesas</label>
				<select style="min-width:90%;" size="10" cssClass="form-control" id="select-hamburguesas" /></select>
			</div>
			<div class="d-flex flex-column bd-highlight mb-3">
				<button id="btn-agregar" class="m-3" type="button">Agregar Hamburguesa</button>
				<button id="btn-quitar" class="m-3" type="button">Quitar Hamburguesa</button>
			</div>

			<div class="col-sm-3">
				<label>Lista de compra</label>
				<form:select style="min-width:90%;" path="hamburguesas" class="form-control" size="10" cssClass="form-control" id="select-lista"/>
			</div>
		</div>
			
		<div class="form-group">
			<label>Importe total</label>
			<form:input id="importe" class="form-control" readonly="true" path="totalPrecio" cssClass="form-control required" />
			<form:errors path="totalPrecio" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Fecha y hora de pedido</label>
			<form:input class="form-control" path="fechaAlta" cssClass="form-control required" id="fecha-pedido"/>
			<form:errors path="fechaAlta" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Fecha y hora de entrega</label>
			<form:input class="form-control" readonly="true" path="fechaEntrega" cssClass="form-control" />
			<form:errors path="fechaEntrega" cssClass="error"/>
		</div>
		<div class="form-check">
		  <input path="pagado" class="form-check-input" type="checkbox" value="true" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		    Pagado
		  </label>

		</div>
		<br>
		<div class="form-check">
		  <input path="entregado"class="form-check-input" type="checkbox" value="" id="entregadoCB">
		  <label class="form-check-label" for="flexCheckDefault">
		    Entregado
		  </label>
		</div>
		<br>
		<button type="submit" class="btn btn-primary" id="btnconfirmar">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>