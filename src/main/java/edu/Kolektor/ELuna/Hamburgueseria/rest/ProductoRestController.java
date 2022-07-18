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

import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.ProductoDTO;
import edu.Kolektor.ELuna.Hamburgueseria.service.HamburgueseriaService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	private static  Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	
	@Autowired
	private HamburgueseriaService hamburgueseriaService;
	
	@GetMapping("/hamburgueseria/productos")
	public List<ProductoDTO> recuperarTodosLosProductos() {
		List<Producto> productos = hamburgueseriaService.recuperarProductos();
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		for (Producto producto : productos) {
			productosDTO.add(new ProductoDTO(producto));
		}
		return productosDTO;
	}
	
	@GetMapping("/hamburgueseria/producto/{id}")
	public ResponseEntity<ProductoDTO> recuperarProductoPorId(@PathVariable Long id){
		Producto producto = hamburgueseriaService.buscarProductoPorId(id);
		ProductoDTO productoDTO = new ProductoDTO(producto);
		return ResponseEntity.ok(productoDTO);
	}
	
	@GetMapping("/hamburguesas/hamburguesa/buscar")
	public List<ProductoDTO> buscarProducto(@RequestParam String nombre, @RequestParam(required = false) Double precio) {
		
		log.info("Param nombre: " + nombre + " Param precio: " + precio);
		List<Producto> productos = null;
		
		if(precio == null)
			productos = hamburgueseriaService.buscarProductos(nombre);		
		else
			productos = hamburgueseriaService.buscarProductos(nombre, precio);	

			
		List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();
		for (Producto producto : productos) {
			productoDTO.add(new ProductoDTO(producto));
		}
		
		return productoDTO;
	}
 
}
