package edu.Kolektor.ELuna.Hamburgueseria.service;

import java.util.List;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Pedido;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;

public interface HamburgueseriaService {

	//Servicios Cliente
	List<Cliente> recuperarClientes();
	Cliente buscarClientePorId(Long id);
	Long guardarNuevoCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	void borrarClientePorId(Long id);
	List<Cliente> buscarClientesPorNombre(String nombre);
	
	//Servicios Direccion
	List<Direccion> recuperarDirecciones();
	Direccion buscarDireccionPorId(Long id);
	Long guardarNuevaDireccion(Direccion direccion);
	void actualizarDireccion(Direccion direccion);
	void borrarDireccionPorId(Long id);
	List<Direccion> buscarDirecciones(String calle);

	
	//Servicios Producto
	List<Producto> recuperarProductos();
	Producto buscarProductoPorId(Long id);
	Long guardarNuevoProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void borrarProductoPorId(Long id);
	List<Producto> buscarProductos(String nombre);
	List<Producto> buscarProductos(String nombre, Double precio);
	
	//Servicios Pedido
	List<Pedido> recuperarPedidos();
	Pedido buscarPedidoPorId(Long id);
	Long guardarNuevoPedido(Pedido pedido);
	void actualizarPedido(Pedido pedido);
	void borrarPedidoPorId(Long id);
}
