package com.example.demo.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private  IEmpleadoRepository empleadoRepository;
	
	
	
	
	
	@Override
	public void crear(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
