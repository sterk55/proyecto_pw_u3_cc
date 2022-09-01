package com.example.demo.uce.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "hijo")
public class Hijo {
	@Id
	@Column(name = "hijo_id")
	private Integer id;
	
	@Column(name = "hijo_nombre")
	private String nombre;
	
	@Column(name = "hijo_apellido")
	private String apellido;
	
	@Column(name = "hijo_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "hijo_genero")
	private String genero; 
	
	@ManyToOne
	@JoinColumn(name = "hijo_id_empleado")
	private Empleado empleado;
	

	
	//SET y GET
	
	
	
	
	public String getGenero() {
		return genero;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	
	
	
	
	
	
	
	
}
