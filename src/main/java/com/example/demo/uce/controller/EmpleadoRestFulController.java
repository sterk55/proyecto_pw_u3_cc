package com.example.demo.uce.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.IEmpleadoService;
import com.example.demo.uce.service.to.EmpleadoTo;
import com.example.demo.uce.service.to.HijoTo;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestFulController {

	@Autowired
    private IEmpleadoService empleadoService;
    
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String crear(@RequestBody Empleado empleado) {
        String mensaje = "Empleado Insertado Correctamente";
        try {
            this.empleadoService.crear(empleado);    
        } catch (Exception e) {
            mensaje = "Error intente mas tarde";
        }
        
        return mensaje;
    }
    
    @PutMapping
    public String actualizar(@RequestBody Empleado empleado) {
        this.empleadoService.actualizar(empleado);
        return "Empleado Actualizado";
    }
    
    @GetMapping(path = "/{idEmpleado}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Empleado> buscarEmpleado(@PathVariable("idEmpleado") Integer idEmpleado){
        Empleado empl = this.empleadoService.buscarPorId(idEmpleado);
        return ResponseEntity.ok(empl);
    }
    
    @GetMapping(path = "/status/{idEmpleado}")
    public ResponseEntity<Empleado> buscarEmpleadoStatus(@PathVariable("idEmpleado") Integer idEmpleado){
        Empleado empl = this.empleadoService.buscarPorId(idEmpleado);
        return ResponseEntity.status(227).body(empl);
    }
    
    @GetMapping(path = "/headers/{idEmpleado}")
    public ResponseEntity<Empleado> buscarEmpleadoHeaders(@PathVariable("idEmpleado") Integer idEmpleado){
        HttpHeaders headers = new HttpHeaders();
        headers.add("detalleMensaje", "Estas bien pero envia el apellido adicional");
        headers.add("solicitud", "Recuerda consumirme mañana");
        headers.add("valor", "1");
        Empleado empl = this.empleadoService.buscarPorId(idEmpleado);
        return new ResponseEntity<>(empl, headers, HttpStatus.OK);
    }
    
    //buscar todos con HATEOAS
    @GetMapping(path = "/salarios")
    public List<Empleado> buscarPorSalario(@RequestParam(value="salario")BigDecimal salarioEmpl){
        List<Empleado> listaEmpl = this.empleadoService.buscarSalario(salarioEmpl);
        return listaEmpl;
    }
    
    //tener muy en cuenta la forma del path
    @GetMapping(path = "/{idEmpleado}/hijos")
    public List<HijoTo> buscarTodosHijos(@PathVariable("idEmpleado") Integer idEmpleado){
        return null;
    }
    
    @GetMapping
    public List<EmpleadoTo> buscarTodosEmpleados(){
        List<EmpleadoTo> listEmpl = this.empleadoService.buscarTodos();
        for(EmpleadoTo empl: listEmpl) {
            //construyendo los links para cada empleado
            Link myLink = linkTo(methodOn(EmpleadoRestFulController.class).buscarTodosHijos(empl.getId())).withRel("hijos");
            empl.add(myLink);
        }
        return listEmpl;
    }
    
    @DeleteMapping(path = "/{idEmpleado}")
    public String eliminar(@PathVariable("idEmpleado") Integer idEmpleado) {
        this.empleadoService.eliminar(idEmpleado);
        return "Eliminado Correcto";
    }
}

