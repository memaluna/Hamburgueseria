package edu.Kolektor.ELuna.Hamburgueseria.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "PedidoHam")
public class Pedido {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	private String direccionEntrega;
	private String descripcion;
	private Double totalImporte;
	
	@Column(name = "fechaAlta")
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidoId")
	private List<Detalle> detalles;
	
	@PrePersist
	public void prePersist() {
		this.fechaAlta = new Date();
	}
	
	public Pedido() {
		this.detalles = new ArrayList<Detalle>();
	}

	public Pedido(Long id, Cliente cliente, Date fechaAlta, List<Detalle> detalles) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fechaAlta = fechaAlta;
		this.detalles = detalles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}
	
	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	public Double getTotalImporte() {
		return totalImporte;
	}

	public void setTotalImporte(Double totalImporte) {
		this.totalImporte = totalImporte;
	}

	public void addItemFactura(Detalle detalle) {
		this.detalles.add(detalle);
	}

	public Double getTotal() {
		Double total = 0.0;
		int size = detalles.size();
		for (int i = 0; i < size; i++) {
			total += detalles.get(i).calcularImporte();
		}
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, descripcion, detalles, direccionEntrega, fechaAlta, id, totalImporte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(detalles, other.detalles) && Objects.equals(direccionEntrega, other.direccionEntrega)
				&& Objects.equals(fechaAlta, other.fechaAlta) && Objects.equals(id, other.id)
				&& Objects.equals(totalImporte, other.totalImporte);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", direccionEntrega=" + direccionEntrega + ", descripcion="
				+ descripcion + ", totalImporte=" + totalImporte + ", fechaAlta=" + fechaAlta + ", detalles=" + detalles
				+ "]";
	}


	
}
