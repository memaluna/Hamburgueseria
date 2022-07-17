package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findAllByOrderById();
}