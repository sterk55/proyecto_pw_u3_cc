package com.example.demo.uce.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.uce.repository.modelo.Empleado;

public class HijoTo extends RepresentationModel<HijoTo> implements Serializable {
	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private LocalDateTime fechaNacimiento;

	private String genero; 
	
	private Empleado empleado;
	
}
