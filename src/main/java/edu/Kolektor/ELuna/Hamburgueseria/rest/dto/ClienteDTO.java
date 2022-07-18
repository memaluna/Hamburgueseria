package edu.Kolektor.ELuna.Hamburgueseria.rest.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public class ClienteDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String telefono;
	private List <Direccion> direcciones = new ArrayList<Direccion>();
	private String email;
	private LocalDate fechaAlta;
	
	public ClienteDTO() {}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nombre = cliente.getNombre();
		this.apellido = cliente.getApellido();
		this.telefono = cliente.getTelefono();
		this.direcciones = cliente.getDirecciones();
		this.email = cliente.getEmail();
		this.fechaAlta = cliente.getFechaAlta();
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

	
	
}
