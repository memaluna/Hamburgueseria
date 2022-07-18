<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
		//definimos dos arreglos con id de producto y cantidad de producto
 		let item_id =  [];
		let cantidad = [];
		let pedido = {};
 		$(document).ready(function() {
 			moment.locale('es');
			//$('#select-hamburguesas').select2();			
			$('#select-clientes').select2({
				theme: 'bootstrap4'
			});
			$('#direccion').select2({
				theme: 'bootstrap4'
			});
			$('#select-producto').select2({
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
				        url: "http://localhost:8080/api/hamburgueseria/cliente/" + this.value
				    }).then(function(data) {
				    	$('#direccion').empty();     
				       $.each(data.direcciones, function (i, item) {
				    	    $('#direccion').append($('<option>', { 
				    	        value: item.id,
				    	        text : item.direccionFull 
				    	    }));
				    	});
				    });
			    }else{
			    	$("#direccion").val("");
			    } 
			});
						
			
			 //logica para agregar y quitar producto a lista de compras.
			$("#agregar-producto").click(function() {				
				//console.log("evento");
				//console.log($("#select-producto").val());
				let idProducto = $("#select-producto").val();
				//peticion ajax para traer datos de producto 
				$.ajax({
				        url: "http://localhost:8080/api/hamburgueseria/producto/" + idProducto
				    }).then(function(data) {
						console.log(data);
						agregarFila(data.id, data.nombre, data.precio, calcularSubtotal(data.precio, 1), 1);

				    });
				
			});
			
			//Cargar fecha de pedido
			$("#fecha-pedido").val(moment().format("DD-MM-YYYY hh:mm:ss"));
						
			
			$(document).on('DOMNodeInserted', $('.subtotal'), function() {
				sumar_columnas()
			});
			
			$(document).on('click', '#btn-borrar', function(event) {
				  event.preventDefault();
				  $(this).closest('tr').remove();
		 			sumar_columnas();
		 			let idElegido = $(this).parent().parent().find('.data').text();
		 			delete pedido[idElegido];
		 			console.log(pedido);
				});
			
		}); 
 		
 		
 		$(document).on("click", "#btnconfirmar", function () {

 			//Dividimos el objeto pedido y lo comvertimos en dos arrays integer para poder pasarlos como param
 			cantidad = Object.values(pedido);
 			//console.log(cantidad);
 			item_id = Object.keys(pedido);
 			item_id = item_id.map(x => parseInt(x));
 			//console.log(item_id);
 			
 			var input = $("<input>").attr("type", "hidden").attr("name", "item_id[]").val(item_id); 
 			$('#form-pedido').append($(input));
 			var input2 = $("<input>").attr("type", "hidden").attr("name", "cantidad[]").val(cantidad); 
 			$('#form-pedido').append($(input2));
 			
 			$('#direccion-elegida').val($("#direccion option:selected").text());

 		    });			
 		
 		function agregarFila(id, nombre, precio, subtotal, cant) {
 		   //Algoritmo para ver si hay producto repedito
			if(!pedido.hasOwnProperty(id)) {
				//sino existe agregar linea y agregar id a array
				pedido[id] = 1;
				item_id.push(id);
		 		var htmlTags = '<tr>'+
	 		        '<td class=data id=' + id +'>' + id + '</td>'+
	 		        '<td>' + nombre + '</td>'+
	 		        '<td><input type="number" value="1" min=1 id=' + id +' onchange="actualizarCantidad(id, value, '+precio+')"/></td>'+
	 		        '<td>' + precio + '</td>'+
	 		        '<td id=sub'+id+' class=subtotal>' + subtotal + '</td>'+
		            '<td><a id="btn-borrar"><svg height="16px" width="16px" xmlns="http://www.w3.org/2000/svg"><path fill="#FF5858" d="M7.5 0C6.4 0 5.355.32 5.355.32L5 .428v1.683A13.88 13.88 0 0 0 2.002 3L2 4H1v1h1l.004 9c0 .439.04.788.15 1.082.111.294.311.528.563.668.503.28 1.12.25 1.953.25h5.664c.833 0 1.45.03 1.953-.25.252-.14.45-.374.56-.668.11-.294.153-.643.153-1.082l-.002-8h-1L12 14c0 .376-.04.603-.088.729-.034.09-.078.129-.11.146-.173.097-.611.125-1.468.125H4.67c-.857 0-1.295-.028-1.469-.125a.267.267 0 0 1-.113-.146v-.002c-.046-.122-.084-.348-.084-.727v-.002L3 5h11V4h-1.002L13 3a13.855 13.855 0 0 0-3-.889V.449L9.67.33S8.757 0 7.5 0zm0 1c.89 0 1.29.155 1.5.22v.739a14.05 14.05 0 0 0-1.498-.084c-.502 0-1.003.032-1.502.086v-.734C6.266 1.157 6.772 1 7.5 1zM5 6v6h1V6zm2 0v6h1V6zm2 0v6h1V6z" fill="gray" font-family="Ubuntu" font-size="15" font-weight="400" letter-spacing="0" style="line-height:125%;-inkscape-font-specification:Ubuntu;text-align:center" text-anchor="middle" word-spacing="0"/></svg></a></td>'
			   '</tr>';  
	 		   $('#tabla-productos tbody').append(htmlTags);
	 		   console.log(pedido);
			}
 		}
 		
 		function imprimir(){
 			console.log(cantidad);
 		}
 		
 		function actualizarCantidad(id, valor, precio){
 			pedido[id] = parseInt(valor);
 			$('#sub'+id).text(valor*precio);
 			sumar_columnas();
 			console.log(pedido);
 		}
 				
 		function calcularSubtotal(precio, cantidad){
 			return precio * cantidad;
 		}
 		
 		function sumar_columnas(){
 			var sum=0;
 			    //itera cada input de clase .subtotal y la suma
 			    $('.subtotal').each(function() {     
 			            sum += parseFloat($(this).text());                     
 			    }); 
 			    //cambia valor del total y lo redondea a la segunda decimal
 			    $('#importetotal').val(sum.toFixed(2));
 			}
 				
	</script>

	<h1>Cargar nuevo pedido</h1>
	<form:form method="post" action="/hamburgueseria/pedido/guardar" modelAttribute="pedidoForm" id="form-pedido">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Fecha y hora de pedido</label>
			<form:input class="form-control" path="fechaAlta" cssClass="form-control required" id="fecha-pedido"/>
			<form:errors path="fechaAlta" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Cliente</label>
			<form:select path="cliente" items="${clientes}" itemLabel="FullDatos" itemValue="id" cssClass="form-control" id="select-clientes" />
		</div>
		<div class="form-group">
			<label>Dirección de entrega</label>
			<form:select path="cliente" itemLabel="Direcciones" itemValue="id" cssClass="form-control" id="direccion" />
		</div>
		<div class="form-group" style="display: none">
			<label>Direccion elegida</label>
			<form:input class="form-control" path="direccionEntrega" cssClass="form-control required" id="direccion-elegida"/>
			<form:errors path="direccionEntrega" cssClass="error"/>
		</div>
		<div class="form-group">
			<label>Descripción</label>
			<form:input class="form-control" path="descripcion" cssClass="form-control required" id="descripcion"/>
			<form:errors path="descripcion" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label>Producto a agregar</label>
			<form:select path="cliente" items="${productos}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-producto" />
				<button id="agregar-producto" type="button" style="margin-top: 1em;">Agregar Producto</button>
		</div>
 				<table  id="tabla-productos" class="table table-striped">
				    <tr class="table-primary">
				        <th>ID</th>
				        <th>Nombre</th>
				        <th>Cantidad</th>
				        <th>Precio unidad</th>
				        <th>Subtotal</th>
				        <th></th>
				    </tr>
				</table> 
		<div class="form-group">
			<label>Importe total</label>
			<input id="importetotal" readonly="true" class="form-control"/>
		</div>	
		<button type="submit" class="btn btn-primary" id="btnconfirmar">Enviar datos</button>
	</form:form>
<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>