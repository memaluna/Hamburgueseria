package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findAllByOrderById();
	@Query("select p from Cliente as p where p.nombre like ?1%")
	List<Cliente> buscarClientesPorNombre(String nombre);

}
