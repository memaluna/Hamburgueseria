package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	List<Producto> findAllByOrderById();
}
