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

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.ClienteDTO;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.DireccionDTO;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.ProductoDTO;
import edu.Kolektor.ELuna.Hamburgueseria.service.HamburgueseriaService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {


	private static  Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	
	@Autowired
	private HamburgueseriaService hamburgueseriaService;
	
	@GetMapping("/hamburgueseria/clientes")
	public List<ClienteDTO> recuperarTodosLosClientes() {
		List<Cliente> clientes = hamburgueseriaService.recuperarClientes();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ClienteDTO(cliente));
		}
		return clientesDTO;
	}
	
	@GetMapping("/hamburgueseria/cliente/{id}")
	public ResponseEntity<ClienteDTO> recuperarClientePorId(@PathVariable Long id){
		System.out.println("Busc cl " + id);
		Cliente cliente = hamburgueseriaService.buscarClientePorId(id);
		ClienteDTO clienteDTO = new ClienteDTO(cliente);
		return ResponseEntity.ok(clienteDTO);
	}
	
	@GetMapping("/hamburguesas/cliente/buscar")
	public List<ClienteDTO> buscarCliente(@RequestParam String nombre, @RequestParam(required = false) Long id) {
		
		log.info("Param nombre: " + nombre + " Param id: " + id);
		List<Cliente> clientes = null;		
		clientes = hamburgueseriaService.buscarClientesPorNombre(nombre);					
		List<ClienteDTO> clienteDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			clienteDTO.add(new ClienteDTO(cliente));
		}
		return clienteDTO;
	}
	
}
