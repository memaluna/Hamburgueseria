<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<script type="text/javascript">
	$(document).ready(function() {

	});	
</script>


<div class="card">
  <h5 class="card-header">Dirección id: ${direccion.id}</h5>
  <div class="card-body">
    <h5 id="direccion" class="card-text">${direccion.calle} ${direccion.numero}</h5>
    <p id="localidad" class="card-text">${direccion.localidad}</p>
    <p id="provincia" class="card-text">${direccion.provincia}</p>
    <p id="pais" class="card-text">${direccion.pais}</p>
  </div>
</div>
<div id="map"></div>
<br>
<button onclick="history.back()" class="btn btn-primary">Volver</button>

<script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&callback=initMap&v=weekly"
      defer>
</script>
<script>
	
	let direccion = $('#direccion').text() +", "+ $('#localidad').text() +", " +$('#pais').text();
	//direccion = "Salta 476, Malagueño, Argentina";
	console.log(direccion);	

	function initMap(lat, lng) {
		  const myLatLng = {};
			myLatLng["lat"] = parseFloat(lat);
			myLatLng["lng"] = parseFloat(lng);
		  const map = new google.maps.Map(document.getElementById("map"), {
		    zoom: 18,
		    center: myLatLng,
		  });

		  new google.maps.Marker({
		    position: myLatLng,
		    map,
		    title: "Destino de pedido!",
		  });
		}
	geocodeAddress(direccion, "619cabeb955b4c9485c33cc0fb323ad2");
	function geocodeAddress(address, APIK) {
		  if (!address || address.length < 3) {
		    console.log("The address string is too short. Enter at least three symbols");
		    return;
		  }
		  const geocodingUrl = "https://api.geoapify.com/v1/geocode/search?text=" + encodeURIComponent(address) + "&apiKey=" + APIK;		  
		  // call Geocoding API - https://www.geoapify.com/geocoding-api/
		  fetch(geocodingUrl).then(result => result.json())
		    .then(featureCollection => {
		     	console.log(featureCollection);
				window.initMap = initMap(featureCollection.features[0].geometry.coordinates[1], featureCollection.features[0].geometry.coordinates[0]);
		      //myMap(featureCollection.features[0].geometry.coordinates[1], featureCollection.features[0].geometry.coordinates[0]);
		    });
		}

</script>


<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
