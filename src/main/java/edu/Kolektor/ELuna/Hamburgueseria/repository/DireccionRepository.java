package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	List<Direccion> findAllByOrderById();
}
