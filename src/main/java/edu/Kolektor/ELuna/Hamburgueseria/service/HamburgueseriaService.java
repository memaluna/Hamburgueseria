package edu.Kolektor.ELuna.Hamburgueseria.service;

import java.util.List;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public interface HamburgueseriaService {

	//Servicios Cliente
	List<Cliente> recuperarClientes();
	Cliente buscarClientePorId(Long id);
	Long guardarNuevoCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	void borrarClientePorId(Long id);
	
	//Servicios Direccion
	List<Direccion> recuperarDirecciones();
	Direccion buscarDireccionPorId(Long id);
	Long guardarNuevaDireccion(Direccion direccion);
	void actualizarDireccion(Direccion direccion);
	void borrarDireccionPorId(Long id);
	
}
