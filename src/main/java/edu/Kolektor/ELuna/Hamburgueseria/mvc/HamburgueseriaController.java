package edu.Kolektor.ELuna.Hamburgueseria.mvc;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;
import edu.Kolektor.ELuna.Hamburgueseria.mvc.form.ClienteForm;
import edu.Kolektor.ELuna.Hamburgueseria.service.HamburgueseriaService;



@Controller
@RequestMapping("/hamburgueseria")
public class HamburgueseriaController {
	
	private static  Logger log = LoggerFactory.getLogger(HamburgueseriaController.class);
	@Autowired
	private HamburgueseriaService hamburgueseriaService;
	
	//Cliente ------------------>
	
	@GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute("clienteForm", new ClienteForm());
		System.out.println(model);
		return "/hamburgueseria/clienteform";
	}

	@PostMapping("/cliente/guardar")
	public String guardarCliente(@Valid @ModelAttribute(name = "clienteForm") ClienteForm clienteForm, BindingResult bindingResult, Model model) {

		
		  log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
		  if(bindingResult.hasErrors()) { System.out.println("tiene errores " +
		  clienteForm); model.addAttribute("clienteForm", clienteForm); return
		  "/hamburgueseria/clienteform"; }
		 
		
		Cliente cliente = null;
		Long idCliente = clienteForm.getId();
		System.out.println("estado id " + idCliente);
		if(idCliente == null) {
			cliente = new Cliente();
		} else {
			cliente = hamburgueseriaService.buscarClientePorId(idCliente);
		}
		
		cliente.setNombre(clienteForm.getNombre());
		cliente.setApellido(clienteForm.getApellido());
		cliente.setTelefono(clienteForm.getTelefono());
		//cliente.setDirecciones(clienteForm.getDirecciones());
		cliente.setEmail(clienteForm.getEmail());
		cliente.setFechaAlta(clienteForm.getFechaAlta());
		
		//variables bo Direccion
		Direccion direccion = new Direccion();
		direccion.setCalle(clienteForm.getCalle());
		direccion.setNumero(clienteForm.getNumero());
		direccion.setBarrio(clienteForm.getBarrio());
		direccion.setCliente(cliente);
		
		
		if(idCliente == null) {
			try {
				hamburgueseriaService.guardarNuevoCliente(cliente);
				hamburgueseriaService.guardarNuevaDireccion(direccion);
			} catch (Exception e) {
				log.error("Error al guardar un nuevo cliente!", e.getMessage());
				return "redirect:/error";
			}

		} else {
			hamburgueseriaService.actualizarCliente(cliente);
			hamburgueseriaService.actualizarDireccion(direccion);
		}

		return "redirect:/hamburgueseria/clientes";
	}
	
	@GetMapping("/clientes")
	public String listarClientes(Model model) {
		List<Cliente> clientes= hamburgueseriaService.recuperarClientes();
		model.addAttribute("clientes", clientes);
		return "/hamburgueseria/listarclientes";
	}
	
	@GetMapping("cliente/{id}/borrar")
	public String borrarCliente(Model model, @PathVariable Long id) {
		hamburgueseriaService.borrarClientePorId(id);
		return "redirect:/hamburgueseria/clientes";
	}
	
	@GetMapping("/cliente/{id}/editar")
	public String editarCliente(Model model, @PathVariable Long id) {
		Cliente cliente = hamburgueseriaService.buscarClientePorId(id);
		System.out.println(cliente);
		ClienteForm clienteForm = new ClienteForm();
		clienteForm.setId(cliente.getId());
		clienteForm.setNombre(cliente.getNombre());
		clienteForm.setApellido(cliente.getApellido());
		clienteForm.setTelefono(cliente.getTelefono());
		clienteForm.setDirecciones(cliente.getDirecciones());
		clienteForm.setEmail(cliente.getEmail());
		clienteForm.setFechaAlta(cliente.getFechaAlta());
				
		model.addAttribute("clienteForm", clienteForm);
		return "/hamburgueseria/clienteform";
	}
	
	@GetMapping("/cliente/{id}")
	public String verCliente(Model model, @PathVariable Long id) {
		Cliente cliente = hamburgueseriaService.buscarClientePorId(id);
		model.addAttribute("cliente", cliente);
		return "/hamburgueseria/vercliente";
	}
}