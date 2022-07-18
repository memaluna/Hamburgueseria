package edu.Kolektor.ELuna.Hamburgueseria.rest;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.DireccionDTO;
import edu.Kolektor.ELuna.Hamburgueseria.service.HamburgueseriaService;

@RestController
@RequestMapping("/api")
public class DireccionRestController {


	private static  Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	
	@Autowired
	private HamburgueseriaService hamburgueseriaService;
	
	@GetMapping("/hamburgueseria/direcciones")
	public List<DireccionDTO> recuperarTodosLasDirecciones() {
		List<Direccion> direcciones = hamburgueseriaService.recuperarDirecciones();
		List<DireccionDTO> direccionesDTO = new ArrayList<DireccionDTO>();
		for (Direccion direccion : direcciones) {
			direccionesDTO.add(new DireccionDTO(direccion));
		}
		return direccionesDTO;
	}
	
	@GetMapping("/hamburgueseria/direccion/{id}")
	public ResponseEntity<DireccionDTO> recuperarDireccionPorId(@PathVariable Long id){
		Direccion direccion = hamburgueseriaService.buscarDireccionPorId(id);
		DireccionDTO direccionDTO = new DireccionDTO(direccion);
		return ResponseEntity.ok(direccionDTO);
	}
	
	@GetMapping("/hamburgueseria/producto/buscar")
	public List<DireccionDTO> buscarProducto(@RequestParam String nombre, @RequestParam(required = false) Double precio) {
		
		log.info("Param nombre: " + nombre + " Param precio: " + precio);
		List<Direccion> direcciones = null;
		direcciones = hamburgueseriaService.buscarDirecciones(nombre);				
		List<DireccionDTO> direccionDTO = new ArrayList<DireccionDTO>();
		for (Direccion direccion : direcciones) {
			direccionDTO.add(new DireccionDTO(direccion));
		}
		return direccionDTO;
	}
 
}
