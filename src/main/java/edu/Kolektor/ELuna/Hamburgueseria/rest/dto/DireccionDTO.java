package edu.Kolektor.ELuna.Hamburgueseria.rest.dto;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public class DireccionDTO {

	private Long id;
	private String calle;
	private String numero;
	private String localidad;
	private String provincia;
	private String pais;
	
	public DireccionDTO() {}

	public DireccionDTO(Direccion direccion) {
		super();
		this.id = direccion.getId();
		this.calle = direccion.getCalle();
		this.numero = direccion.getNumero();
		this.localidad = direccion.getLocalidad();
		this.provincia = direccion.getProvincia();
		this.pais = direccion.getPais();
	}

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

	
}
