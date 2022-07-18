package edu.Kolektor.ELuna.Hamburgueseria.mvc.form;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Producto;

public class DetalleForm {
	
	private Long id;
	private Long cantidad;
	private Producto producto;
	
	public DetalleForm() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleForm [id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + "]";
	}

}
