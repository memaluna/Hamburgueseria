<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Producto id: ${producto.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${producto.nombre}</h5>
    <p class="card-text"><b>Ingredientes: </b>${producto.ingredientes}</p>
    <p class="card-text"><b>Precio: </b>${producto.precio}</p>      
  </div>
</div>
<br>
<button onclick="history.back()" class="btn btn-primary">Volver</button>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
