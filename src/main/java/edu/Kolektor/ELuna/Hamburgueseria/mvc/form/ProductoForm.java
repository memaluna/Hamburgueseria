package edu.Kolektor.ELuna.Hamburgueseria.mvc.form;

public class ProductoForm {
	
	private Long id;
	private String nombre;
	private String ingredientes;
	private Float precio;
	
	public ProductoForm() {
		super();
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

	@Override
	public String toString() {
		return "ProductoForm [id=" + id + ", nombre=" + nombre + ", ingredientes=" + ingredientes + ", precio=" + precio
				+ "]";
	}

}
