package edu.Kolektor.ELuna.Hamburgueseria.bo;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "ProductoHam")
public class Producto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String ingredientes;
	private Float precio;
	
	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, String ingredientes, Float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.precio = precio;
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
	public int hashCode() {
		return Objects.hash(id, ingredientes, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(ingredientes, other.ingredientes)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", ingredientes=" + ingredientes + ", precio=" + precio
				+ "]";
	}
}
