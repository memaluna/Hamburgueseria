package edu.Kolektor.ELuna.Hamburgueseria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;
import edu.Kolektor.ELuna.Hamburgueseria.repository.ClienteRepository;
import edu.Kolektor.ELuna.Hamburgueseria.repository.DireccionRepository;
import edu.Kolektor.ELuna.Hamburgueseria.repository.ProductoRepository;

@Service
public class HamburgueseriaServiceImpl implements HamburgueseriaService{
	
	//Inyeccion de repositorys

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DireccionRepository direccionRepository;
	@Autowired
	private ProductoRepository productoRepository;
	
	//Implementacion Clientes
	
	@Override
	public List<Cliente> recuperarClientes() {
		return clienteRepository.findAllByOrderById();
	}

	@Override
	public Cliente buscarClientePorId(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		return clienteOptional.get();
	}

	@Override
	public Long guardarNuevoCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente.getId();
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		clienteRepository.save(cliente);		
	}

	@Override
	public void borrarClientePorId(Long id) {
		clienteRepository.deleteById(id);	
	}
	
	//implementacion Direccion

	@Override
	public List<Direccion> recuperarDirecciones() {
		return direccionRepository.findAllByOrderById();
	}

	@Override
	public Direccion buscarDireccionPorId(Long id) {
		Optional<Direccion> direccionOptional = direccionRepository.findById(id);
		return direccionOptional.get();
	}

	@Override
	public Long guardarNuevaDireccion(Direccion direccion) {
		direccionRepository.save(direccion);
		return direccion.getId();
	}

	@Override
	public void actualizarDireccion(Direccion direccion) {
		direccionRepository.save(direccion);
	}

	@Override
	public void borrarDireccionPorId(Long id) {
		direccionRepository.deleteById(id);	
	}

	//Productos ------------------------>
	@Override
	public List<Producto> recuperarProductos() {
		return productoRepository.findAllByOrderById();
	}

	@Override
	public Producto buscarProductoPorId(Long id) {
		Optional<Producto> productoOptional = productoRepository.findById(id);
		return productoOptional.get();
	}

	@Override
	public Long guardarNuevoProducto(Producto producto) {
		productoRepository.save(producto);
		return producto.getId();
	}

	@Override
	public void actualizarProducto(Producto producto) {
		productoRepository.save(producto);		
	}

	@Override
	public void borrarProductoPorId(Long id) {
		productoRepository.deleteById(id);		
	}
	
}
