package edu.Kolektor.ELuna.Hamburgueseria.bo;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "DireccionHam")
public class Direccion {
	
	@Id
	@GeneratedValue
	private Long id;
	private String calle;
	private String numero;
	private String barrio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;
	
	public Direccion() {
		super();
	}

	public Direccion(Long id, String calle, String numero, String barrio, Cliente cliente) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
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

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barrio, calle, cliente, id, numero);
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
		return Objects.equals(barrio, other.barrio) && Objects.equals(calle, other.calle)
				&& Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", barrio=" + barrio + ", cliente="
				+ cliente + "]";
	}
	
	
}
