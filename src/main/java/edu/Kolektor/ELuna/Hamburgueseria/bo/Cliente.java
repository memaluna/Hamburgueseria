package edu.Kolektor.ELuna.Hamburgueseria.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "ClienteHam")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellido;
	private String telefono;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List <Direccion> direcciones = new ArrayList<Direccion>();
	private String email;
	private LocalDate fechaAlta;
	
	public Cliente() {
		super();
	}

	public Cliente(Long id, String nombre, String telefono, List<Direccion> direcciones, String email,
			LocalDate fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direcciones = direcciones;
		this.email = email;
		this.fechaAlta = fechaAlta;
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
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, direcciones, email, fechaAlta, id, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(direcciones, other.direcciones)
				&& Objects.equals(email, other.email) && Objects.equals(fechaAlta, other.fechaAlta)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direcciones=" + direcciones + ", email=" + email + ", fechaAlta=" + fechaAlta + "]";
	}




}
