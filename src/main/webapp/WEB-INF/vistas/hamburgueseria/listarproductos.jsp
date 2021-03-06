<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de Productos</h1>

<script type="text/javascript">
	$(document).ready(function() {
		$('#btn-borrar').on('click', function(event) {
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
			<th>Ingredientes</th>
			<th>Precio</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${productos}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.nombre}</td>
			<td>${p.ingredientes}</td>
			<td>${p.precio}</td>
			<td>
				<a href="/hamburgueseria/producto/${p.id}">
					<svg height="16px" width="16px" id="Layer_1" style="enable-background:new 0 0 128 128;" version="1.1" viewBox="0 0 128 128" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><g>
					<path fill="#3AEF6E" d="M109,55c0-29.8-24.2-54-54-54C25.2,1,1,25.2,1,55s24.2,54,54,54c13.5,0,25.8-5,35.2-13.1l25.4,25.4l5.7-5.7L95.9,90.2   C104,80.8,109,68.5,109,55z M55,101C29.6,101,9,80.4,9,55S29.6,9,55,9s46,20.6,46,46S80.4,101,55,101z"/>
					<path fill="#97FBB4" d="M25.6,30.9l6.2,5.1C37.5,29,46,25,55,25v-8C43.6,17,32.9,22.1,25.6,30.9z"/>
					<path fill="#97FBB4" d="M17,55h8c0-2.1,0.2-4.1,0.6-6.1l-7.8-1.6C17.3,49.8,17,52.4,17,55z"/></g></svg>
				</a>&nbsp;
				<a href="/hamburgueseria/producto/${p.id}/editar">
				<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
					 width="16px" height="16px" viewBox="0 0 485.219 485.22" style="enable-background:new 0 0 485.219 485.22;"
					 xml:space="preserve">
					<g>
					<path fill="#5656FF" d="M467.476,146.438l-21.445,21.455L317.35,39.23l21.445-21.457c23.689-23.692,62.104-23.692,85.795,0l42.886,42.897
					C491.133,84.349,491.133,122.748,467.476,146.438z M167.233,403.748c-5.922,5.922-5.922,15.513,0,21.436
					c5.925,5.955,15.521,5.955,21.443,0L424.59,189.335l-21.469-21.457L167.233,403.748z M60,296.54c-5.925,5.927-5.925,15.514,0,21.44
					c5.922,5.923,15.518,5.923,21.443,0L317.35,82.113L295.914,60.67L60,296.54z M338.767,103.54L102.881,339.421
					c-11.845,11.822-11.815,31.041,0,42.886c11.85,11.846,31.038,11.901,42.914-0.032l235.886-235.837L338.767,103.54z
					 M145.734,446.572c-7.253-7.262-10.749-16.465-12.05-25.948c-3.083,0.476-6.188,0.919-9.36,0.919
					c-16.202,0-31.419-6.333-42.881-17.795c-11.462-11.491-17.77-26.687-17.77-42.887c0-2.954,0.443-5.833,0.859-8.703
					c-9.803-1.335-18.864-5.629-25.972-12.737c-0.682-0.677-0.917-1.596-1.538-2.338L0,485.216l147.748-36.986
					C147.097,447.637,146.36,447.193,145.734,446.572z"/></svg>
				</a>&nbsp;
				<a href="/hamburgueseria/producto/${p.id}/borrar" id="btn-borrar">
					<svg height="16px" width="16px" xmlns="http://www.w3.org/2000/svg">
						    <path fill="#FF5858" d="M7.5 0C6.4 0 5.355.32 5.355.32L5 .428v1.683A13.88 13.88 0 0 0 2.002 3L2 4H1v1h1l.004 9c0 .439.04.788.15 1.082.111.294.311.528.563.668.503.28 1.12.25 1.953.25h5.664c.833 0 1.45.03 1.953-.25.252-.14.45-.374.56-.668.11-.294.153-.643.153-1.082l-.002-8h-1L12 14c0 .376-.04.603-.088.729-.034.09-.078.129-.11.146-.173.097-.611.125-1.468.125H4.67c-.857 0-1.295-.028-1.469-.125a.267.267 0 0 1-.113-.146v-.002c-.046-.122-.084-.348-.084-.727v-.002L3 5h11V4h-1.002L13 3a13.855 13.855 0 0 0-3-.889V.449L9.67.33S8.757 0 7.5 0zm0 1c.89 0 1.29.155 1.5.22v.739a14.05 14.05 0 0 0-1.498-.084c-.502 0-1.003.032-1.502.086v-.734C6.266 1.157 6.772 1 7.5 1zM5 6v6h1V6zm2 0v6h1V6zm2 0v6h1V6z" 
						    fill="gray" font-family="Ubuntu" font-size="15" font-weight="400" letter-spacing="0" style="line-height:125%;-inkscape-font-specification:Ubuntu;text-align:center" text-anchor="middle" word-spacing="0"/>
					</svg>		
				</a>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>