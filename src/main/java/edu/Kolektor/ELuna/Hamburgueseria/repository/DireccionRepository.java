package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	List<Direccion> findAllByOrderById();
	@Query("select p from Direccion as p where p.calle like ?1%")
	List<Direccion> buscarDireccion(String calle);
}
