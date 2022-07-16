<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Hamburguesa id: ${hamburguesa.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${hamburguesa.nombre}</h5>
    <p class="card-text">Precio: <fmt:formatNumber type="number" value="${hamburguesa.precio}" /> </p>
 	<c:forEach items="${hamburguesa.ingredientes}" var="c">
		<span class="badge bg-warning">${c.nombre}</span>
	</c:forEach>    
  </div>
</div>
<br>
<button onclick="history.back()" class="btn btn-primary">Volver</button>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
