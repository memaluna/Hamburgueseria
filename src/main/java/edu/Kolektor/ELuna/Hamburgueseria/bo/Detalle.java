package edu.Kolektor.ELuna.Hamburgueseria.bo;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="DetalleHam")
public class Detalle {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
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

	public Double calcularImporte() {
		return this.cantidad.doubleValue() * producto.getPrecio();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detalle other = (Detalle) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(id, other.id)
				&& Objects.equals(producto, other.producto);
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + "]";
	}
	
}
