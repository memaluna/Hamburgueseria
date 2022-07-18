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
import edu.Kolektor.ELuna.Hamburgueseria.bo.Pedido;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.ClienteDTO;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.DireccionDTO;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.PedidoDTO;
import edu.Kolektor.ELuna.Hamburgueseria.rest.dto.ProductoDTO;
import edu.Kolektor.ELuna.Hamburgueseria.service.HamburgueseriaService;

@RestController
@RequestMapping("/api")
public class PedidoRestController {


	private static  Logger log = LoggerFactory.getLogger(ProductoRestController.class);
	
	@Autowired
	private HamburgueseriaService hamburgueseriaService;
	
	@GetMapping("/hamburgueseria/pedidos")
	public List<PedidoDTO> recuperarTodosLosPedidos() {
		List<Pedido> pedidos = hamburgueseriaService.recuperarPedidos();
		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			pedidosDTO.add(new PedidoDTO(pedido));
		}
		return pedidosDTO;
	}
	
	@GetMapping("/hamburgueseria/pedido/{id}")
	public ResponseEntity<PedidoDTO> recuperarPedidoPorId(@PathVariable Long id){
		System.out.println("Busc cl " + id);
		Pedido pedido = hamburgueseriaService.buscarPedidoPorId(id);
		PedidoDTO pedidoDTO = new PedidoDTO(pedido);
		return ResponseEntity.ok(pedidoDTO);
	}
		
}
