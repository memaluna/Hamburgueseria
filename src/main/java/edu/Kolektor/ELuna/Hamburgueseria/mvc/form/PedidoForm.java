package edu.Kolektor.ELuna.Hamburgueseria.mvc.form;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Detalle;

public class PedidoForm {
	
	private Long id;
	private Cliente cliente;
	private String direccionEntrega;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date fechaAlta;
	private List<Detalle> detalles;
	private String descripcion;
	private Double totalImporte;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void addItemFactura(Detalle detalle) {
		this.detalles.add(detalle);
	}
	public Double getTotalImporte() {
		return totalImporte;
	}
	public void setTotalImporte(Double totalImporte) {
		this.totalImporte = totalImporte;
	}
	@Override
	public String toString() {
		return "PedidoForm [id=" + id + ", cliente=" + cliente + ", direccionEntrega=" + direccionEntrega
				+ ", fechaAlta=" + fechaAlta + ", detalles=" + detalles + ", descripcion=" + descripcion
				+ ", totalImporte=" + totalImporte + "]";
	}

}
