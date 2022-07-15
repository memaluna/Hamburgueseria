package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findAllByOrderById();
}
