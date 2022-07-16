package edu.Kolektor.ELuna.Hamburgueseria.mvc.form;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;

public class DireccionForm {

	private Long id;
	private String calle;
	private String numero;
	private String localidad;
	private String provincia;
	private String pais;
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "DireccionForm [id=" + id + ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", pais=" + pais + ", cliente=" + cliente + "]";
	}
	
}
