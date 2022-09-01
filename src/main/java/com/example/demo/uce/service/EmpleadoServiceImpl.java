package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.to.EmpleadoTo;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private  IEmpleadoRepository empleadoRepository;
	
	
	
	
	
	@Override
	public void crear(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.crear(empleado);

	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.actualizar(empleado);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepository.eliminar(id);

	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.buscar(id);
	}

	@Override
	public List<Empleado> buscarSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.buscarSalario(salario);
	}

	@Override
	public List<EmpleadoTo> buscarTodos() {

		List<Empleado> lista = this.empleadoRepository.buscarTodos();
		List<EmpleadoTo> listaFinal = lista.stream().map(empleado -> this.convertir(empleado)).collect(Collectors.toList());
		
		return listaFinal;
	}
	
	private EmpleadoTo convertir(Empleado e) {
		
		EmpleadoTo empl = new EmpleadoTo();
		empl.setId(e.getId());
		empl.setNombre(e.getNombre());
		empl.setApellido(e.getApellido());
		empl.setFechaNacimiento(e.getFechaNacimiento());
		return empl;
		
		
	}
}
