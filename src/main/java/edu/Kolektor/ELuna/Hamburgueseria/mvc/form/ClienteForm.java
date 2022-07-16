package edu.Kolektor.ELuna.Hamburgueseria.mvc.form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import edu.Kolektor.ELuna.Hamburgueseria.bo.Cliente;
import edu.Kolektor.ELuna.Hamburgueseria.bo.Direccion;

public class ClienteForm {

	private Long id;
	
	@NotBlank
	private String nombre;
	private String apellido;
	private String telefono;
	private List <Direccion> direcciones = new ArrayList<Direccion>();
	
	//variables de bo Direccion
	private Long idDireccion;
	private String calle;
	private String numero;
	private String barrio;
	private Cliente cliente;
	
	//continuan variables de cliente
	private String email;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaAlta;
	
	public ClienteForm() {
		super();
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

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
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
	public String toString() {
		return "ClienteForm [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direcciones=" + direcciones + ", idDireccion=" + idDireccion + ", calle=" + calle + ", numero="
				+ numero + ", barrio=" + barrio + ", cliente=" + cliente + ", email=" + email + ", fechaAlta="
				+ fechaAlta + "]";
	}


	
}
