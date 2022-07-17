package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Detalle;

public interface DetalleRepository extends JpaRepository<Detalle, Long>{
	List<Detalle> findAllByOrderById();
}