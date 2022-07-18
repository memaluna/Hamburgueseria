package edu.Kolektor.ELuna.Hamburgueseria.rest.dto;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;

public class ProductoDTO {

	private Long id;
	private String nombre;
	private String ingredientes;
	private Float precio;
	
	public ProductoDTO() {}

	public ProductoDTO(Producto producto) {
		super();
		this.id = producto.getId();
		this.nombre = producto.getNombre();
		this.ingredientes = producto.getIngredientes();
		this.precio = producto.getPrecio();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
}
