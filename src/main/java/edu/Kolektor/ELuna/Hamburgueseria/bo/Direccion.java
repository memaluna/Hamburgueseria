package edu.Kolektor.ELuna.Hamburgueseria.bo;

import java.util.Objects;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DireccionHam")
public class Direccion {
	
	@Id
	@GeneratedValue
	private Long id;
	private String calle;
	private String numero;
	private String localidad;
	private String provincia;
	private String pais;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;
	
	public Direccion() {
		super();
	}

	public Direccion(Long id, String calle, String numero, String localidad, String provincia, String pais,
			Cliente cliente) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getDireccionFull() {
		return this.getCalle() + " " + this.getNumero() + " - " + this.getLocalidad();
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, cliente, id, localidad, numero, pais, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(id, other.id) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(numero, other.numero) && Objects.equals(pais, other.pais)
				&& Objects.equals(provincia, other.provincia);
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", pais=" + pais + ", cliente=" + cliente.getId() + "]";
	}	
	
}
