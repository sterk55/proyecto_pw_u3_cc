package com.example.demo.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.repository.modelo.Hijo;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void crear(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Empleado buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
		
	}
	
	@Override
	public List<Empleado> buscarSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.salario > : salarioDato", Empleado.class);
		myQuery.setParameter("salarioDato", salario);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Empleado> buscarTodos() {
TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM", Empleado.class);

return myQuery.getResultList();
	}

	public List<Hijo> buscarHijosEmpleado(Integer id) {
TypedQuery<Hijo> myQuery = this.entityManager.createQuery("SELECT e FROM Hijo h WHERE h.empleado.id", Hijo.class);
myQuery.setParameter("id", id);
return myQuery.getResultList();
	}
	


}
