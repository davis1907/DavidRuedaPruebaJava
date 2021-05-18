package com.itehl.api.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.itehl.api.service.IModalidadService;
import com.itehl.api.model.Curso;
import com.itehl.api.model.Modalidad;
import com.itehl.api.model.ResponseService;

@RestController
@RequestMapping("/rest/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ModalidadController {
	
	private static final Logger logger = LoggerFactory.getLogger(ModalidadController.class);
	
	@Autowired
	private IModalidadService iModalidadervice; 
	
	

	@GetMapping("modalidades")
    public List<Modalidad> listarModalidad(@RequestParam(name="idModalidad", required=false, defaultValue="") Long id) {
        return iModalidadervice.listarModalidades(id);
    }
	
	@GetMapping("modalidad")
    public Modalidad obtenerModalidad(@RequestParam(name="idModalidad", required=false, defaultValue="") Long id) {
        return iModalidadervice.listarModalidades(id).get(0);
    }
    
    
    @PostMapping(path="modalidades", produces = "application/json")
    public ResponseService<Modalidad> crearModalidad (@RequestBody Modalidad modalidad){
    	ResponseService<Modalidad> response = new ResponseService<Modalidad>();
    	Modalidad c=iModalidadervice.crearModalidad(modalidad);
    		response.setCodigo("200");
	    	response.setMessage("Modalidad creado exitosamente");
	    	
	    	 logger.debug("Modalidad creado exitosamente con Id " + c.getId());
		
    	return response;
    }
    
    @PutMapping(path="modalidades", produces = "application/json")
    public ResponseService<Modalidad> actualizarModalidad (@RequestBody Modalidad modalidad){
    	ResponseService<Modalidad> response = new ResponseService<Modalidad>();
    	
    	Modalidad c=iModalidadervice.crearModalidad(modalidad);
    		response.setCodigo("200");
	    	response.setMessage("Modalidad actualizado exitosamente");
	    	
	    	 logger.debug("Modalidad actualizado exitosamente con Id " + c.getId());
		
    	return response;
    }
    
    @DeleteMapping(path="modalidades", produces = "application/json")
    public ResponseService<Modalidad> eliminarModalidad (@RequestParam(name="idModalidad", required=true, defaultValue="") Long idModalidad){
    	ResponseService<Modalidad> response = new ResponseService<Modalidad>();
    	List<Modalidad> Modalidad = iModalidadervice.listarModalidades(idModalidad);
    	Modalidad c=null;
    	if(Modalidad.size()>0) {
    		 c= Modalidad.get(0);
    	}
    	
    	if(c!=null)
		{
    		iModalidadervice.eliminarModalidad(idModalidad);
    		response.setCodigo("200");
	    	response.setMessage("Modalidad eliminado exitosamente");
	    	
	    	logger.debug("Modalidad creado eliminado con Id " + c.getId());
	    	
		}
    	else {
    		
    		
    		response.setCodigo("404");
	    	response.setMessage("Modalidad no encontrado");	
    	}
    	return response;
    }


}
