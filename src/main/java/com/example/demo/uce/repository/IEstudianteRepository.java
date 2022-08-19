package com.example.demo.uce.repository;

import com.example.demo.uce.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void crear(Estudiante empleado);
	public void actualizar(Estudiante empleado);
	public void eliminar(Integer id);
	public Estudiante buscar(Integer id);
	
	
}