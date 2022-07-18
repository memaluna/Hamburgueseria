package edu.Kolektor.ELuna.Hamburgueseria.rest.dto;

import java.util.Date;
import java.util.List;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Detalle;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Pedido;

public class PedidoDTO {

	private Long id;
	private Cliente cliente;
	private String direccionEntrega;
	private String descripcion;
	private Double totalImporte;
	private Date fechaAlta;
	private List<Detalle> detalles;
	
	public PedidoDTO() {}

	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.cliente = pedido.getCliente();
		this.direccionEntrega = pedido.getDireccionEntrega();
		this.descripcion = pedido.getDescripcion();
		this.totalImporte = pedido.getTotalImporte();
		this.fechaAlta = pedido.getFechaAlta();
		this.detalles = pedido.getDetalles();
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

	public Double getTotalImporte() {
		return totalImporte;
	}

	public void setTotalImporte(Double totalImporte) {
		this.totalImporte = totalImporte;
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

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	
}
