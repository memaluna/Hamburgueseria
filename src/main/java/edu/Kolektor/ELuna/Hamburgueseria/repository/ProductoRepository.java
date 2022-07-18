package edu.Kolektor.ELuna.Hamburgueseria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	List<Producto> findAllByOrderById();
		
	  @Query("select p from Producto as p where p.nombre like ?1%")
	  List<Producto> buscarProducto(String nombre);
	  
	  @Query("select p from Producto as p where p.nombre like ?1% or p.precio >= ?2"
	  ) List<Producto> buscarProducto(String nombre, Double precio);
	 
}
