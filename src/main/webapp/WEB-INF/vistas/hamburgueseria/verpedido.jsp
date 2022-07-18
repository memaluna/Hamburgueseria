<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Pedido id: ${pedido.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${pedido.cliente.getFullDatos()}</h5>
    <p class="card-text"><b>Fecha Alta: </b>${pedido.fechaAlta}</p>
    <p class="card-text"><b>Dirección de entrega: </b>${pedido.direccionEntrega}</p>   
    <p class="card-text"><b>Descripción: </b>${pedido.descripcion}</p>         
    <p class="card-text"><b>Total Importe: </b>${pedido.totalImporte}</p>     
    <p><b>Productos:</b><br>
    	<c:forEach items="${pedido.detalles}" var="v" varStatus="status">
			<span class="badge bg-warning">${v.id} - ${v.producto.getNombre()} x ${v.cantidad}</span>
		</c:forEach>
    </p>    
  </div>
</div>
<br>
<button onclick="history.back()" class="btn btn-primary">Volver</button>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
