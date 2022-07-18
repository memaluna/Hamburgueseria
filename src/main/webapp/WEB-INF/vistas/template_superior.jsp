<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hamburguesas</title>
	
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootbox.all.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/messages_es_AR.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/select2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.selectlistactions.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/moment-with-locales.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/leaflet.js"/>"></script>
		
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@ttskch/select2-bootstrap4-theme@x.x.x/dist/select2-bootstrap4.min.css">
		
	<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/select2.min.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/general.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/leaflet.css"/>" rel="stylesheet" >

	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</head>
<body>

	<header>
	  <!-- Fixed navbar -->
	  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	    <a class="navbar-brand" href="<c:url value="/hamburgueseria"/>">Hamburguesas</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarCollapse">
	      <ul class="navbar-nav mr-auto">
	      	<li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburgueseria/clientes"/>">Listado de clientes</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburgueseria/cliente/nuevo"/>">Nuevo cliente</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburgueseria/pedidos"/>">Listado de pedidos</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburgueseria/pedido/nuevo"/>">Nuevo pedido</a>
	        </li>
	       	<li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburgueseria/productos"/>">Listado de productos</a>
	        </li>
	       	<li class="nav-item">
	          <a class="nav-link" href="<c:url value="/hamburgueseria/producto/nuevo"/>">Nuevo producto</a>
	        </li>
	      </ul>
	    </div>
	  </nav>
	</header>


	<div class="container">
	<!-- INICIO CONTENIDO -->